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

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    private CountryAdapter.OnTouchItem onTouchItem;
    private ArrayList<ExampleItem2> mExampleList;

    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item2, parent, false);
        return new CountryAdapter.MyViewHolder(v, onTouchItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.MyViewHolder holder, int position) {
        ExampleItem2 currentItem=  mExampleList.get(position);

        holder.Confirmed.setText(currentItem.getConfirmed()+"");
        holder.Deaths.setText(currentItem.getDeaths()+"");
        holder.Recovered.setText(currentItem.getRecovered()+"");
        holder.Active.setText(currentItem.getActive()+"");
        holder.Date.setText(currentItem.getDate());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public CountryAdapter(ArrayList<ExampleItem2> exampleList, CountryAdapter.OnTouchItem onTouchItem){
        mExampleList = exampleList;
        this.onTouchItem = onTouchItem;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView Confirmed;
        public TextView Deaths;
        public TextView Recovered;
        public TextView Active;
        public TextView Date;

        public CountryAdapter.OnTouchItem onTouchItem;
        public MyViewHolder(@NonNull View itemView, CountryAdapter.OnTouchItem onTouchItem) {
            super(itemView);
            this.onTouchItem = onTouchItem;

            Confirmed = itemView.findViewById(R.id.Confirmed);
            Deaths = itemView.findViewById(R.id.Deaths);
            Recovered = itemView.findViewById(R.id.Recovered);
            Active = itemView.findViewById(R.id.Active);
            Date = itemView.findViewById(R.id.Date);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public interface OnTouchItem{
        void onTouch(int position);
    }
        public void setTT(ArrayList<ExampleItem2> exampleList){
        this.mExampleList=exampleList;
        notifyDataSetChanged();
        }

    public void setPostt(ArrayList<ExampleItem2> mExampleList ){
        this.mExampleList=mExampleList;
        notifyDataSetChanged();
    }

}