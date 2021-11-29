package com.example.foodsystem;
import java.util.ArrayList;

public class Restaurant {
    String name;
    int image;
    String closeHour;
    String cuisine;
    String address;
    String openHour;
    ArrayList<ResturantItem> menu;

    public Restaurant(String name, int image, String closeHour, String cuisine, String address, String openHour) {
        this.name = name;
        this.image = image;
        this.menu = new ArrayList<ResturantItem>();
        this.closeHour = closeHour;
        this.cuisine = cuisine;
        this.address = address;
        this.openHour = openHour;
        this.menu = new ArrayList<ResturantItem>();
    }


    public Restaurant(String name, int image, String closeHour, String cuisine, String address, String openHour, ArrayList<ResturantItem> menu) {
        this.name = name;
        this.image = image;
        this.menu = new ArrayList<ResturantItem>();
        this.closeHour = closeHour;
        this.cuisine = cuisine;
        this.address = address;
        this.openHour = openHour;
        this.menu = menu;
    }}