package com.example.foodsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements res_card_adapter.OnResListener {
    private static final String TAG = "res_card";
    RecyclerView recyclerView;
    ImageView adl_image, adr_image; // right and left images for ad
    TextView adText;
    LinearLayout ad_layout;
    Advertisment ad;
    Context context;
    DatabaseReference database;
    res_card_adapter myAdapter;
    ArrayList<Restaurant> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        recyclerView = findViewById(R.id.restaurantlist);
        database = FirebaseDatabase.getInstance().getReference("restaurants");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new res_card_adapter(this, list, this);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Restaurant restaurant = dataSnapshot.getValue(Restaurant.class);
                    list.add(restaurant);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Log.d(TAG, "onCreate: before ad");
        // set ad ids
        ad_layout = findViewById(R.id.adLayout);
        adr_image = findViewById(R.id.gifRight);
        adl_image = findViewById(R.id.gifLeft);
        adText = findViewById(R.id.adText);

        database = FirebaseDatabase.getInstance().getReference("ad");

        // Get vals from database
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ad = snapshot.getValue(Advertisment.class);

                ad_layout.setBackgroundColor(Color.parseColor(ad.color));
                adText.setText(ad.text);
                Glide.with(context).asGif().load(ad.lgif).into(adl_image);
                Glide.with(context).asGif().load(ad.rgif).into(adr_image);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onResClick(int position) {
        Restaurant restaurant = list.get(position);
        Intent intent = new Intent(this, menu_view.class);
        intent.putExtra("Restaurant", list.get(position));
        startActivity(intent);
    }
}