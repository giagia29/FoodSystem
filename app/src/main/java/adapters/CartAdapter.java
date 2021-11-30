package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsystem.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import models.Food;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public List<Cart> cart;

    public CartAdapter(List<Cart> cart) {
        this.cart = cart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart itemincart = cart.get(position);
        if (itemincart == null){
            return;
        }
        holder.imgItembuy.setImageResource(itemincart.getResourceID());
        holder.fname.setText(itemincart.getName());
        holder.fprice.setText(itemincart.getPrice());
    }

    @Override
    public int getItemCount() {
        if (cart != null){
            return cart.size();
        }
        return 0;
    }



    public class CartViewHolder extends RecyclerView.ViewHolder{
        TextView fname;
        TextView fprice;
        ImageView imgItembuy;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItembuy = itemView.findViewById(R.id.iv_foodbuy);
            fname = itemView.findViewById(R.id.tv_foodname);
            fprice = itemView.findViewById(R.id.tv_foodprice);

        }
    }
}
