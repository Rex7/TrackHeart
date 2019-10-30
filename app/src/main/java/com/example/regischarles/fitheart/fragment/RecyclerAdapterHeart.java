package com.example.regischarles.fitheart.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.regischarles.fitheart.R;

public class RecyclerAdapterHeart extends RecyclerView.Adapter<RecyclerAdapterHeart.ViewHolder> {
private String[] arrayList={"80 bpm","75 bpm","65 bpm","120 bpm","55 bpm","120 bpm"};
private String[] message={"heart is functioning normally","heart beat is rising","heart is functioning normally","heart is functioning normally but sudden rise is shown","heart is functioning normally","heart is beating fast"};
private Context ctx;

    public RecyclerAdapterHeart(Context ctx) {
        this.ctx=ctx;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
      viewHolder.report.setText(arrayList[position]);
      viewHolder.message.setText(message[position]);
    }

    @Override
    public int getItemCount() {
        return arrayList.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
TextView report;
TextView message;
         ViewHolder(@NonNull View itemView) {
            super(itemView);
            report=itemView.findViewById(R.id.display_rate);
            message=itemView.findViewById(R.id.bpmMesasge);
        }
    }
}
