package com.example.regischarles.fitheart.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.regischarles.fitheart.R;

@SuppressLint("ValidFragment")
public class heartreport extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerAdapterHeart recyclerAdapterHeart;
    Context ctx;

    public heartreport(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerAdapterHeart=new RecyclerAdapterHeart(ctx);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.heartreport,container,false);
        recyclerView=view.findViewById(R.id.HeartReport);
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        recyclerView.setClipToPadding(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapterHeart);
        return view;
    }
}
