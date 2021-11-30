package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Cart_View extends AppCompatActivity implements menu_item_adapter.OnMIListener {
    RecyclerView recyclerView;
    Cart cart;
    menu_item_adapter adapter;
    public static final String TAG = "cart_view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        cart = intent.getParcelableExtra("Cart");

        adapter = new menu_item_adapter(this, cart.getItems(), this);
        recyclerView.setAdapter(adapter);

        final Button button = findViewById(R.id.Submitbtn);
        button.setText(String.format("%.2f", cart.total));
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), Cart_View.class);
//                intent.putExtra("Cart", cart);
//                startActivity(intent);
                    Intent i = new Intent(getBaseContext(), Payment.class);
                    i.putExtra("Cart", cart);
                    startActivity(i);
            }
        });
    }

    public void onMIClick(int position){
//        MenuItem item = cart.restaurant.menuu.get(position);
//        cart.items.remove(position);
//        cart.total -= Double.parseDouble(item.price);
//        Log.d(TAG, "onMIClick: item removed");
//
//        adapter = new menu_item_adapter(this, cart.getItems(), this);
//        recyclerView.setAdapter(adapter);
    }
}