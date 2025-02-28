package com.example.project8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Inner>{
    ArrayList<Model> data;

    Context context;

    public NewsAdapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public NewsAdapter.Inner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
                View view= inflater.inflate(R.layout.news_item,parent,false);
        return new Inner((view));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.Inner holder, int position) {
        holder.txt_title.setText(data.get(position).title);
        holder.txt_description.setText(data.get(position).description);
        Glide.with(context).load(data.get(position).urlToImage).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Inner extends RecyclerView.ViewHolder {

            ImageView img;
            TextView txt_title, txt_description;


        public Inner(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.myimage);
            txt_title = itemView.findViewById(R.id.title);
            txt_description = itemView.findViewById(R.id.description);

        }
    }
}





