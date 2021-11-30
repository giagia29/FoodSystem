package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
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
        textView.setPaintFlags(textView.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG);
        button.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty()) {
                textView.setText("");
                Toast.makeText(this, "No input Try again", Toast.LENGTH_SHORT).show();
            } else if (editText.getText().toString().length() < 10 || editText.getText().toString().length() > 10) {

                Toast.makeText(this, "Student Id should be 10 digits", Toast.LENGTH_SHORT).show();

            } else {
                textView.setText("ID Successful");
                id = editText.getText().toString();
                Intent downloadIntent = new Intent(getApplicationContext(),DeliveryMethod.class);
                startActivity(downloadIntent);
            }
        });
    }
}