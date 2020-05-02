package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder>{
    private  OnTouchItem onTouchItem;
    private ArrayList<ExampleItem> mExampleList;

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(v, onTouchItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExampleItem currentItem=  mExampleList.get(position);
        holder.textView.setText(currentItem.getTitle());
        String s= "https://www.countryflags.io/"+currentItem.getUrl()+"/flat/64.png";
        Picasso.get()
                .load(s)
//               .placeholder(R.drawable.place)
//                .centerCrop()
//                .resize(150, 150)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public CountriesAdapter(ArrayList<ExampleItem> exampleList, OnTouchItem onTouchItem){
        mExampleList = exampleList;
        this.onTouchItem = onTouchItem;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public  OnTouchItem onTouchItem;
        public MyViewHolder(@NonNull View itemView, OnTouchItem onTouchItem) {
            super(itemView);
            this.onTouchItem = onTouchItem;
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.coutry_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTouchItem.onTouch(getAdapterPosition());
        }
    }

    public interface OnTouchItem{
        void onTouch(int position);
    }
  public void setPosts(ArrayList<ExampleItem> mExampleList){
        this.mExampleList=mExampleList;
        notifyDataSetChanged();
  }
}
