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


public class RecyclerAdapterDemo extends RecyclerView.Adapter<RecyclerAdapterDemo.ViewHolders> {
    String[] data={"520mb","24mb","45mb","185mb","900mb"};
    String[] Name={"call of duty","pubg","jetpack","poker","Risk"};
    int[] image={R.drawable.callofduty,R.drawable.pubg,R.drawable.poker,R.drawable.joyride,R.drawable.risk} ;
    Context ctx;
    public RecyclerAdapterDemo(Context ctx){
       this.ctx=ctx;
    }
    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical,viewGroup,false);
        return new RecyclerAdapterDemo.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders ViewHolders, int i) {
        ViewHolders.name.setText(Name[i]);
        ViewHolders.gameSize.setText(data[i]);
        Glide.with(ctx).load(image[i]).into(ViewHolders.holderImage);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolders extends RecyclerView.ViewHolder{
     TextView name,gameSize;
     ImageView holderImage;
        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.gameName);
            gameSize=itemView.findViewById(R.id.data);
            holderImage=itemView.findViewById(R.id.ImageViewVertical);

        }
    }
}
