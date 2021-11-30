package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeliveryMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_method);

        Button Delivery,Pickup;

        Delivery = findViewById(R.id.D);
        Pickup = findViewById(R.id.PU);

        Delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"You chose Delivery",Toast.LENGTH_SHORT);
                toast.show();
                Intent downloadIntent = new Intent(getApplicationContext(),Delivery.class);
                startActivity(downloadIntent);

            }
        });
        Pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"You chose Pick-up",Toast.LENGTH_SHORT);
                toast.show();
                Intent downloadIntent = new Intent(getApplicationContext(),Pickup.class);
                startActivity(downloadIntent);
            }
        });
    }
}