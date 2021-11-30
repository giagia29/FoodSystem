package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Delivery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Button CS,CD,OR;

        CD = findViewById(R.id.contact);
        CS = findViewById(R.id.status);
        OR = findViewById(R.id.OrderRecvied);

        CD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Your Driver information is 817-555-5555", Toast.LENGTH_LONG);
                toast.show();

            }
        });
        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                Toast toast = Toast.makeText(getApplicationContext(), "Sending you to Communication Page", Toast.LENGTH_LONG);
                toast.show();

            }
        });
        OR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), review.class));


            }
        });
    }
}
