package com.example.foodsystem;

public class ResturantItem {
    String name;
    String description;
    int prepTime;
    Double price;

    public ResturantItem(String name, int prepTime, String description, Double price) {
        this.name = name;
        this.prepTime = prepTime;
        this.description = description;
        this.price = price;
    }
}
