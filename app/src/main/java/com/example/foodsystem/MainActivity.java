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
import java.util.Collections;

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
                "Chick-Fil-A",
                "Burger King",
                "Mcdonalds"
        };

        imageResourceID = new int[]{
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

        ArrayList<ResturantItem> menuOne = new ArrayList<ResturantItem>();
        ResturantItem itemOne = new ResturantItem("Bigger Plate", 100, "Orange Chicken, Honey Walnut Shrimp, Grilled Teryaki Chicken and Fried Rice",9.30);
        ResturantItem itemTwo = new ResturantItem("Bowl", 60, "Orange Chicken, and Fried Rice",6.30);
        ResturantItem itemThree = new ResturantItem("Drink", 20, "Fountain Drink",2.30);
        ResturantItem itemFour = new ResturantItem("Plate", 90, "Orange Chicken, Honey Walnut Shrimp, and Fried Rice",7.80);
        Collections.addAll(menuOne, itemOne, itemTwo, itemThree, itemFour);
        Restaurant resturantOne = new Restaurant("Panda Express", R.drawable.b, "21:00", "Chinese", "1000 N Collins St, Arlington, TX 76011", "10:00 - 23:59", menuOne);

        ArrayList<ResturantItem> menuTwo = new ArrayList<ResturantItem>();
        ResturantItem itemFive = new ResturantItem("baconnator", 100, "Baconnator Burger,  Medium Fry, and a Medium Drink",9.99);
        ResturantItem itemSix = new ResturantItem("daves", 70, "Dave's classic single patty burger, Medium Fry, and a Medium Drink",7.29);
        ResturantItem itemSeven = new ResturantItem("fiveDollarBB", 60, "Small Bacon Burger, Five Piece nugget, Small Fry, and a Drink",5.30);
        ResturantItem itemEight = new ResturantItem("homestyle", 150, "Classic Homestyle Chicken Sandwich, Medium Fry, and a Medium Drink",7.29);
        Collections.addAll(menuTwo, itemFive, itemSix, itemSeven, itemEight);
        Restaurant resturantTwo = new Restaurant("Wendy's", R.drawable.c, "23:59", "FastFood", "409 W Abram st, Arlington, TX 76010", "9:00 - 22:00", menuTwo);


        Collections.addAll(restaurantArrayList, resturantOne, resturantTwo);

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