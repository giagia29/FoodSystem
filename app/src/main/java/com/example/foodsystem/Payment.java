package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Cart cart;
        Intent intent = getIntent();
        cart = intent.getParcelableExtra("Cart");

        Button meal,credit,backcart;
        meal = findViewById(R.id.MP);
        credit = findViewById(R.id.CC);
        backcart = findViewById(R.id.Add);

        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Meal Plan",Toast.LENGTH_SHORT);
                toast.show();
                Intent downloadIntent = new Intent(getApplicationContext(),MealPlan.class);
                startActivity(downloadIntent);

            }
        });

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Credit card",Toast.LENGTH_SHORT);
                toast.show();
                Intent downloadIntent = new Intent(getApplicationContext(),CreditCard.class);
                startActivity(downloadIntent);
            }
        });

        backcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Cart_View.class);
                intent.putExtra("Cart", cart);
                startActivity(intent);

            }
        });
    }
}