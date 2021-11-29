package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsystem.R;

import java.util.List;

import models.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    List<Food> listfood;
    IClickAddtoCartListener iClickAddtoCartListener;

    public interface IClickAddtoCartListener{
        void onClickAddtoCart(ImageView imgAddtoCart, Food food);
    }

    public void setData(List<Food> list, IClickAddtoCartListener listener){
        this.listfood = list;
        this.iClickAddtoCartListener = listener;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = listfood.get(position);
        if (food == null)
        {
            return;
        }
        holder.imgFood.setImageResource(food.getResourceID());
        holder.foodname.setText(food.getFname());
        holder.foodprice.setText(food.getFprice());

        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    iClickAddtoCartListener.onClickAddtoCart(holder.imgAdd, food);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listfood != null){
            return listfood.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFood;
        TextView foodname;
        TextView foodprice;
        ImageView imgAdd;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.orange_chicken);
            foodname = itemView.findViewById(R.id.food);
            foodprice = itemView.findViewById(R.id.price);
            imgAdd = itemView.findViewById(R.id.addcart);
        }
    }
}
