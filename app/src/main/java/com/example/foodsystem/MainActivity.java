package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.codepath.asynchttpclient.AsyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.RestaurantAdapter;
import models.Restaurants;
import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String RESTAURANT_URL = "https://api.documenu.com/v2/restaurants/zip_code/11211?key=29097152aed3193596430123ebc1f309";
    public static final String TAG = "MainActivity";
    List<Restaurants> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvRestaurant = findViewById(R.id.rvRestaurant);
        restaurants = new ArrayList<>();
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, restaurants);

        rvRestaurant.setAdapter(restaurantAdapter);
        rvRestaurant.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(RESTAURANT_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray data = jsonObject.getJSONArray("data");
                    Log.i(TAG, "IMPORTED DATA SUCCESS");
                    restaurants.addAll(Restaurants.fromJsonArray(data));
                    restaurantAdapter.notifyDataSetChanged();
                    Log.i(TAG, "Restaurants: " + restaurants.size());
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                }

            }
            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
    }

}