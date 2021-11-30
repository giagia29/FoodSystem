package com.example.foodsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class menu_view extends AppCompatActivity implements menu_item_adapter.OnMIListener {
    Cart cart;
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
        cart = new Cart();
        cart.restaurant = intent.getParcelableExtra("Restaurant");
        //Log.d(TAG, "onCreate: " + restaurant.getMenu().toString());

        // Get menu from database
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("restaurants/"+cart.restaurant.getId()+"/menu");
        cart.restaurant.menuu = new ArrayList<MenuItem>();
        ValueEventListener event = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MenuItem item = dataSnapshot.getValue(MenuItem.class);
                    cart.restaurant.menuu.add(item);
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

        adapter = new menu_item_adapter(this, cart.restaurant.getMenu());
        recyclerView.setAdapter(adapter);
    }

    public void onMIClick(int position){

    }
}