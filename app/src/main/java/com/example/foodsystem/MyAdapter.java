package com.example.foodsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    Context context;
    ArrayList<Restaurant> restaurantArrayList;
    ArrayList<Restaurant> restaurantArrayListFull;
    private  RecyclerViewClickListener listener;

    public MyAdapter(Context context, ArrayList<Restaurant> restaurantArrayList, RecyclerViewClickListener listener) {
        this.context = context;
        this.restaurantArrayListFull = restaurantArrayList;
        this.restaurantArrayList = new ArrayList<>(restaurantArrayListFull);
        this.listener = listener;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Restaurant restaurant = restaurantArrayList.get(position);
        holder.restaurant_name.setText(restaurant.name);
        holder.titleImage.setImageResource(restaurant.image);
        holder.cuisine.setText(restaurant.cuisine);
        holder.openHour.setText(restaurant.openHour);
        holder.address.setText(restaurant.address);
    }

    @Override
    public int getItemCount() {
        return restaurantArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return restaurantFilter;
    }
    private final Filter restaurantFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Restaurant> filteredRestaurantList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                filteredRestaurantList.addAll(restaurantArrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Restaurant restaurant : restaurantArrayListFull) {
                    if(restaurant.name.toLowerCase().contains(filterPattern))
                        filteredRestaurantList.add(restaurant);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredRestaurantList;
            results.count = filteredRestaurantList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            restaurantArrayList.clear();
            restaurantArrayList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView restaurant_name;
        ShapeableImageView titleImage;
        TextView cuisine;
        TextView openHour;
        TextView address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurant_name = itemView.findViewById(R.id.Restaurant_name);
            titleImage = itemView.findViewById(R.id.title_image);
            cuisine = itemView.findViewById(R.id.Cuisine);
            openHour = itemView.findViewById(R.id.ClosingTime);
            address = itemView.findViewById(R.id.Address);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
