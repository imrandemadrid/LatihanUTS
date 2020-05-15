package com.imran.latihanuts;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/*
    Mohamad Imran 10117170 IF5
    Tanggal pengerjaan Kamis 14 Mei
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {
    private final List<Integer> mItem;

    public GridAdapter(final List<Integer> items){
        mItem = items;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent, false);
        return new MyViewHolder(view);


    }



    @Override

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Integer item = mItem.get(position);
        holder.mimageView.setImageResource(item);

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mimageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageView = (ImageView) itemView.findViewById(R.id.isigallery);

        }




    }
}
