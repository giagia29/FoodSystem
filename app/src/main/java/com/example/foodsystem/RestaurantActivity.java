package com.example.foodsystem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView recyclerView1;
    ArrayList<Food> FoodArrayList;
    foodAdapter foodAdapter;
    String[] FoodNames;
    int[] imageID;
    String[] foodPrice;
    String[] Description;
    String[] prepTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

        recyclerView1 = findViewById(R.id.foodview);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);

        FoodArrayList = new ArrayList<Food>();

        foodAdapter = new foodAdapter(this, FoodArrayList);
        recyclerView1.setAdapter(foodAdapter);

        FoodNames = new String[]{
                "Bigger Plate",
                "Bowl",
                "Drink",
                "Plate"
        };

        imageID = new int[]{
                R.drawable.big,
                R.drawable.bowl,
                R.drawable.pepsi,
                R.drawable.plate
        };
        foodPrice = new String[]{
                "11.30",
                "7.70",
                "2.30",
                "9.50"
        };

        Description = new String[]{
                "Orange Chicken, Honey Walnut Shrimp, Grilled Teryaki Chicken and Fried Rice",
                "Orange Chicken, and Fried Rice",
                "Fountain Drink",
                "Orange Chicken, Honey Walnut Shrimp, and Fried Rice"
        };

        prepTime = new String[]{
                "3",
                "1",
                "1",
                "2"
        };

        Bundle extras = getIntent().getExtras();
        getData();
    }

    private void getData() {
        for(int i = 0; i < FoodNames.length; i++) {
            Food food = new Food(FoodNames[i],imageID[i], foodPrice[i], Description[i], prepTime[i]);
            FoodArrayList.add(food);
        }
        foodAdapter.notifyDataSetChanged();
    }


}
