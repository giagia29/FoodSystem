package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ArrayList<MenuItem> items;
    double total;
    long payment;
    Restaurant restaurant;

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public long getPayment() {
        return payment;
    }

    public String getMethod() {
        return method;
    }

    String method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
}