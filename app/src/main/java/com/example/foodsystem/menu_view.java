package com.example.foodsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class menu_view extends AppCompatActivity implements menu_item_adapter.OnMIListener {
    Cart Cart;
    RecyclerView recyclerView;
    menu_item_adapter adapter;
    public static final String TAG = "menu_view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);

        recyclerView = findViewById(R.id.itemsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        Cart = new Cart();
        Cart.items = new ArrayList<MenuItem>();
        Cart.restaurant = intent.getParcelableExtra("Restaurant");
        //Log.d(TAG, "onCreate: " + restaurant.getMenu().toString());

        // Get menu from database
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("restaurants/"+ Cart.restaurant.getId()+"/menu");
        Cart.restaurant.menuu = new ArrayList<MenuItem>();
        ValueEventListener event = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MenuItem item = dataSnapshot.getValue(MenuItem.class);
                    Cart.restaurant.menuu.add(item);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: ");
            }
        };
        database.addValueEventListener(event);
        //Log.d(TAG, "onCreate: " + restaurant.getMenu().toString());

        adapter = new menu_item_adapter(this, Cart.restaurant.getMenu(), this);
        recyclerView.setAdapter(adapter);

        final Button button = findViewById(R.id.cartBtn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Cart_View.class);
                intent.putExtra("Cart", Cart);
                startActivity(intent);
            }
        });
    }

    public void onMIClick(int position){
        MenuItem item = Cart.restaurant.menuu.get(position);
        Cart.items.add(item);
    }
}