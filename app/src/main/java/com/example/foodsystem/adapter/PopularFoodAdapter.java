package com.example.foodsystem.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsystem.model.PopularFood;

public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder> {

    Context context;
    List<PopularFood> popularFoodList;


    public PopularFoodAdapter(Context context, List<PopularFood> popularFoodList) {
        this.context = context;
        this.popularFoodList = popularFoodList;
    }

    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return popularFoodList.size();
    }


    public static final class PopularFoodViewHolder extends RecyclerView.ViewHolder{

        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
