package com.example.regischarles.fitheart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RecyclerAdapterThird extends RecyclerView.Adapter<RecyclerAdapterThird.Viewholder> {
  private   Context ctx;
    String[] data={"520mb","24mb","45mb","185mb","900mb"};
    String[] Name={"Tinder","Truecaller","Amazon","Amazon Prime","Happn"};
    int[] image={R.drawable.tinder,R.drawable.truecaller,R.drawable.amazon,R.drawable.prime,R.drawable.happn} ;
     RecyclerAdapterThird(Context ctx){
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public RecyclerAdapterThird.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ite_swipe,viewGroup,false);
        return new RecyclerAdapterThird.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        viewholder.title.setText(Name[i]);
        viewholder.content.setText(data[i]);
        Glide.with(ctx).load(image[i]).into(viewholder.imageView);


    }


    @Override
    public int getItemCount() {
        return data.length;
    }
    class Viewholder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView title,content;
         Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.listTitle);
            content=itemView.findViewById(R.id.ListContent);

        }
    }
}
