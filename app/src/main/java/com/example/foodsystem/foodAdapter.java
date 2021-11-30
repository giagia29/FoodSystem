package com.example.foodsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.MyViewHolder>{

    Context context;
    ArrayList<Food> FoodArrayList;

    public foodAdapter(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        FoodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public foodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull foodAdapter.MyViewHolder holder, int position) {
        Food food = FoodArrayList.get(position);
        String prepTime_string = String.format("%s min(s)", food.Description);
        String price_string = String.format("$ %s", food.prepTime);
        String description_string = String.format(food.price);

        holder.name.setText(food.name);
        holder.image.setImageResource(food.image);
        holder.prepTime.setText(price_string);
        holder.price.setText(description_string);
        holder.description.setText(prepTime_string);
    }

    @Override
    public int getItemCount() {
        return FoodArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ShapeableImageView image;
        TextView prepTime;
        TextView price;
        TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.Food_image);
            prepTime = itemView.findViewById(R.id.price);
            price = itemView.findViewById(R.id.Description);
            description = itemView.findViewById(R.id.prepTime);
        }
    }
}
