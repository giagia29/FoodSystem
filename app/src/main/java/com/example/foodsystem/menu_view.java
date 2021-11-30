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
        cart.items = new ArrayList<MenuItem>();
        cart.restaurant = intent.getParcelableExtra("Restaurant");
        //Log.d(TAG, "onCreate: " + restaurant.getMenu().toString());

        // Get menu from database
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("restaurants/"+ cart.restaurant.getId()+"/menu");
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

        adapter = new menu_item_adapter(this, cart.restaurant.getMenu(), this);
        recyclerView.setAdapter(adapter);

        final Button button = findViewById(R.id.cartBtn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Cart_View.class);
                intent.putExtra("Cart", cart);
                Log.d(TAG, "onClick: " +Double.toString(cart.total));
                startActivity(intent);
            }
        });
    }

    public void onMIClick(int position){
        MenuItem item = cart.restaurant.menuu.get(position);
        cart.items.add(item);
        cart.total += Double.parseDouble(item.price);
    }
}