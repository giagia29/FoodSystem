package com.example.foodsystem;

public class Restaurant {
    String name, closeHour, cuisine, openhour, id;
    Long wait;
    Menu menu;

    public void menu_create(){
        menu = new Menu(id);
    }
    public Long getWait() {
        return wait;
    }

    public String getName() {
        return name;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getOpenhour() {
        return openhour;
    }

//    public Menu getMenu() {
//        return menu;
//    }
}
