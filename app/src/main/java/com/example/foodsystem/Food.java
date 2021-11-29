package com.example.foodsystem;

public class Food {
    String name;
    int image;
    String prepTime;
    String price;
    String Description;

    public Food(String name, int image, String prepTime, String price, String description) {
        this.name = name;
        this.image = image;
        this.prepTime = prepTime;
        this.price = price;
        Description = description;
    }
}
