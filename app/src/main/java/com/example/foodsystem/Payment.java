package com.example.foodsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button meal,credit;
        meal = findViewById(R.id.MP);
        credit = findViewById(R.id.CC);

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
                Intent downloadIntent = new Intent(getApplicationContext(),CreditCard .class);
                startActivity(downloadIntent);
            }
        });

    }
}