package com.example.foodsystem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class res_card_adapter extends RecyclerView.Adapter<res_card_adapter.MyViewHolder> {
    Context context;
    ArrayList<Restaurant> restaurantList;
    private OnResListener res_OnResListener;

    public res_card_adapter(Context context, ArrayList<Restaurant> restaurantList, OnResListener onResListener) {
        this.context = context;
        this.restaurantList = restaurantList;
        this.res_OnResListener = onResListener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.restaurant_card, parent, false);
        return new MyViewHolder(v, res_OnResListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.name.setText(restaurant.getName());
        holder.cuisine.setText(restaurant.getCuisine());
        //holder.waitTime.setText(String.valueOf(restaurant.getWait()) + " Minutes");
        holder.waitTime.setText("30" + " Minutes");
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, cuisine, waitTime;
        OnResListener onResListener;

        public MyViewHolder(@NonNull View restaurantView, OnResListener onResListener){
            super(restaurantView);

            name = restaurantView.findViewById(R.id.rName);
            cuisine = restaurantView.findViewById(R.id.rCuisine);
            waitTime = restaurantView.findViewById(R.id.rWait);
            this.onResListener = onResListener;

            restaurantView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onResListener.onResClick(getAdapterPosition());
        }
    }

    public interface OnResListener {
        void onResClick(int position);
    }
}
