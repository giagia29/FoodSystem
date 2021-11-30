package com.example.foodsystem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class menu_item_adapter extends RecyclerView.Adapter<menu_item_adapter.MyViewHolder>{
    Context context;
    ArrayList<MenuItem> list;
    public static final String TAG = "menu_ia";

    public menu_item_adapter(Context context, ArrayList<MenuItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.menu_item_card, parent, false);
        Log.d(TAG, "onCreateViewHolder: s");
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MenuItem item = list.get(position);
        Log.d(TAG, "onBindViewHolder: " + item.getName());
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.description.setText(item.getDescription());
        //holder.add.
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, price, description;
        Button add;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.miName);
            price = itemView.findViewById(R.id.miWPrice);
            description = itemView.findViewById(R.id.miDescription);
            add = itemView.findViewById(R.id.addbtn);

        }
    }

    public interface OnMIListener{
        void onMIClick(int position);
    }
}
