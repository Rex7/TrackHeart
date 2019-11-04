package com.example.regischarles.fitheart;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.widget.Toast;

public class SimpleRecyclerSwipeDemo extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterSwipe recyclerAdapterThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_swipe_demo);
        recyclerView=findViewById(R.id.myRecylcer);
        recyclerAdapterThird= new RecyclerAdapterSwipe(this);
        recyclerView.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapterThird);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper.SimpleCallback callback= new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Toast.makeText(getApplicationContext(),"swiped ",Toast.LENGTH_LONG).show();
               recyclerAdapterThird.removeItem(i);

            }
        };
        new ItemTouchHelper(callback).attachToRecyclerView(recyclerView);


    }
}
