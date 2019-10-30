package com.example.regischarles.fitheart.fragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.example.regischarles.fitheart.R;

import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.TextMode;

@SuppressLint("ValidFragment")
public class heartmeasure extends Fragment {
    Context ctx;
    private ProgressBar progressBar;
    CircleProgressView mCircleView;
    public heartmeasure(Context ctx) {
    this.ctx=ctx;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.mainheart,container,false);
        mCircleView=view.findViewById(R.id.progressBar);
        mCircleView.setMaxValue(150);

      mCircleView.setUnitSize(50); // if i set the text size i also have to set the unit size
       mCircleView.setAutoTextSize(true); // enable auto text size, previous values are overwritten
        //if you want the calculated text sizes to be bigger/smaller you can do so via
        mCircleView.setUnitScale(0.9f);
        mCircleView.setBarColor(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent));
        mCircleView.setTextScale(0.9f);
        mCircleView.spin(); // start spinning

       mCircleView.setValueAnimated(75); // stops spinning. Spinner spins until on top. Then fills to set value.
        mCircleView.setText("75 bpm"); //shows the given text in the circle view
    mCircleView.setTextMode(TextMode.TEXT); // Set text mode to text to show text


        return view;
    }
}
