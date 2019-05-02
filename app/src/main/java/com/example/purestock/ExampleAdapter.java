package com.example.purestock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView ticker;
        public TextView comName;
        public TextView tranPrice;

        public ExampleViewHolder(View itemView){

            super(itemView);
            ticker = itemView.findViewById(R.id.ticker);
            comName = itemView.findViewById(R.id.comName);
            tranPrice = itemView.findViewById(R.id.tranPrice);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){

        mExampleList = exampleList;

    }


    @Override
    public ExampleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleList.get(position);
        holder.ticker.setText(currentItem.getTicker());
        holder.comName.setText(currentItem.getCompanyName());
        holder.tranPrice.setText(String.valueOf(currentItem.getTransactionPrice()));
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}