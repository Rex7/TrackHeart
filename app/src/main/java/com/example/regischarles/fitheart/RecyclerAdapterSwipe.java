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
import com.example.regischarles.fitheart.fragment.AppModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterSwipe extends RecyclerView.Adapter<RecyclerAdapterSwipe.ViewHolders> {
    private Context ctx;


    ArrayList<AppModel> data=populateLIst();
    int[] image={R.drawable.tinder,R.drawable.truecaller,R.drawable.amazon,R.drawable.prime,R.drawable.happn} ;
     RecyclerAdapterSwipe(Context ctx){
        this.ctx=ctx;
    }
    @NonNull
    @Override
    public RecyclerAdapterSwipe.ViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ite_swipe,viewGroup,false);
        return new RecyclerAdapterSwipe.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterSwipe.ViewHolders  viewHolder, int i) {
        viewHolder.title.setText(data.get(i).getName());
        viewHolder.content.setText(data.get(i).getSize());
        Glide.with(ctx).load(data.get(i).getImageView()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolders extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,content;

         ViewHolders(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ImageViewVertical);
            title=itemView.findViewById(R.id.gameName);
            content=itemView.findViewById(R.id.data);

        }
    }
    public void removeItem(int position){
        data.remove(position);
        notifyItemRemoved(position);

    }
    private ArrayList<AppModel> populateLIst(){
        ArrayList<AppModel> list=new ArrayList<>();
        list.add(new AppModel(R.drawable.amazon,"Amazon","512Mb"));
        list.add(new AppModel(R.drawable.prime,"prime","512Mb"));
        list.add(new AppModel(R.drawable.callofduty,"Call Of Duty","512Mb"));
        list.add(new AppModel(R.drawable.drive,"Drive","512Mb"));
        list.add(new AppModel(R.drawable.happn,"Happn","512Mb"));


        return list;
    }
}
