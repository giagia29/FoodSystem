package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsystem.R;

import java.util.List;

import models.Restaurants;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{

    Context context;
    List<Restaurants> restaurants;

    public RestaurantAdapter(Context context, List<Restaurants> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View restaurantView = LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(restaurantView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurants restaurant= restaurants.get(position);
        holder.bind(restaurant);
    }

    @Override
    public int getItemCount() {
        if (restaurants != null) {
            return restaurants.size();
        }
        else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView address;
        TextView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.restaurant_name);
            phone = itemView.findViewById(R.id.restaurant_phone);
            address = itemView.findViewById(R.id.address);
        }

        public void bind(Restaurants restaurant) {
            name.setText(restaurant.getRestaurant_name());
            phone.setText(restaurant.getRestaurant_phone());
            address.setText(restaurant.getAddress());
        }
    }
}
