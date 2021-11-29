package com.example.foodsystem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);
        TextView nameTxt = findViewById(R.id.textView);

        String restaurantname = "Not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            restaurantname = extras.getString("restaurantname");
        }
        nameTxt.setText(restaurantname);
    }

}
