package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MealPlan extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);
        TextView textView = findViewById(R.id.StuId);
        EditText editText = findViewById(R.id.sId);
        Button button = findViewById(R.id.btn);

        button.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty()) {
                textView.setText("");
                Toast.makeText(this, "No input Try again", Toast.LENGTH_SHORT).show();
            } else if (editText.getText().toString().length() < 10 || editText.getText().toString().length() > 10) {

                Toast.makeText(this, "Student Id should be 10 digits", Toast.LENGTH_SHORT).show();

            } else {
                textView.setText("ID Successful");
                id = editText.getText().toString();
                Intent downloadIntent = new Intent(getApplicationContext(),Delivery.class);
                startActivity(downloadIntent);
            }
        });
    }
}