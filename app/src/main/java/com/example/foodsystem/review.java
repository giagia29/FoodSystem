package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class review extends AppCompatActivity {

    short rating;           // Rating from 1 to 5
    String review;          // Text explanation for rating

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        EditText reviewText = findViewById(R.id.reviewText);

        final Button button = findViewById(R.id.reviewSubmit);
        // when button is clicked get text and move to next page
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                review = reviewText.getText().toString();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rating1btn:
                if (checked)
                    rating = 1;
                break;
            case R.id.rating2btn:
                if (checked)
                    rating = 2;
                break;
            case R.id.rating3btn:
                if (checked)
                    rating = 3;
                break;
            case R.id.rating4btn:
                if (checked)
                    rating = 4;
                break;
            case R.id.rating5btn:
                if (checked)
                    rating = 5;
                break;
        }
    }
}