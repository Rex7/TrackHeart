package com.example.regischarles.fitheart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.view.View;
import android.widget.Toast;

public class SimpleRecyclerSwipeDemo extends AppCompatActivity  {
    RecyclerView recyclerView;
    RecyclerAdapterSwipe recyclerAdapterThird;
    private Drawable icon;
    private ColorDrawable background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_swipe_demo);
        icon=ContextCompat.getDrawable(getApplicationContext(),R.drawable.delete);
        background=new ColorDrawable( getResources().getColor(R.color.colorAccent));
        recyclerView=findViewById(R.id.myRecylcer);
        recyclerAdapterThird= new RecyclerAdapterSwipe(this);
        recyclerView.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapterThird);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper.SimpleCallback callback= new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {



            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                int backgroundCornerOffset=20;
                View itemView =viewHolder.itemView;
                if (dX > 0) { // Swiping to the right
                    background.setBounds(itemView.getLeft(), itemView.getTop(),
                            itemView.getLeft() + ((int) dX) + backgroundCornerOffset,
                            itemView.getBottom());

                } else if (dX < 0) { // Swiping to the left
                    background.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
                            itemView.getTop(), itemView.getRight(), itemView.getBottom());
                } else { // view is unSwiped
                    background.setBounds(0, 0, 0, 0);
                }
                background.draw(c);



            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Toast.makeText(getApplicationContext(),"swiped ",Toast.LENGTH_LONG).show();
                int pos=viewHolder.getAdapterPosition();
               recyclerAdapterThird.removeItem(pos);

            }
        };
        new ItemTouchHelper(callback).attachToRecyclerView(recyclerView);


    }
}
