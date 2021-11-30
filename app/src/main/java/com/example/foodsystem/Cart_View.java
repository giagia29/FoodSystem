package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cart_View extends AppCompatActivity implements menu_item_adapter.OnMIListener {
    RecyclerView recyclerView;
    Cart cart;
    menu_item_adapter adapter;

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
    }

    public void onMIClick(int position){
    }
}