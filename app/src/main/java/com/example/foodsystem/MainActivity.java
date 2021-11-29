package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Restaurant> restaurantArrayList;
    MyAdapter myAdapter;
    String[] restaurantNames;
    int[] imageResourceID;
    private MyAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setOnClickListener();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        restaurantArrayList = new ArrayList<Restaurant>();



        restaurantNames = new String[]{
                "Panda Express",
                "Wendy's",
                "Chick-Fil-A",
                "Burger King",
                "Mcdonalds"
        };

        imageResourceID = new int[]{
                R.drawable.b,
                R.drawable.c,
                R.drawable.a,
                R.drawable.bu,
                R.drawable.m
        };

        getData();
    }

    private void setOnClickListener() {
        listener = new MyAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                intent.putExtra(String.valueOf(restaurantNames), imageResourceID);
                startActivity(intent);
            }
        };
    }

    private void getData() {
        for(int i= 0; i<restaurantNames.length; i++)
        {
            Restaurant restaurant = new Restaurant(restaurantNames[i], imageResourceID[i]);
            restaurantArrayList.add(restaurant);
        }

        myAdapter = new MyAdapter(this, restaurantArrayList, listener);
        recyclerView.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search here!");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}