package com.example.regischarles.fitheart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Demo extends AppCompatActivity {
    RecyclerView recyclerView ,recyclerView2;
    RecyclerAdapterDemo recyclerAdapterDemo;
    SecondAdapter secondAdapter;
    RecyclerAdapterThird recyclerAdapterThird;
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        recyclerView=findViewById(R.id.recyclerViewVertical);
        recyclerView2=findViewById(R.id.secondVerticalRecycler);
        button=findViewById(R.id.buttonDemo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SimpleRecyclerSwipeDemo.class));
            }
        });

        initialiseRecycler();


    }
    private void initialiseRecycler(){
        recyclerAdapterDemo=new RecyclerAdapterDemo(this);
        secondAdapter=new SecondAdapter(this);
        recyclerAdapterThird=new RecyclerAdapterThird(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapterDemo);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(secondAdapter);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        //third recyclerview
       /* recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        recyclerView3.setAdapter(recyclerAdapterThird);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());*/


    }
}
