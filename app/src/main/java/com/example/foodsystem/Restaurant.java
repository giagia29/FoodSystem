package com.example.foodsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Restaurant implements Parcelable{
    String name, closeHour, cuisine, openHour, id, image_ref;
    Long wait;
    ArrayList<MenuItem> menuu;

    public Restaurant(String name, String closeHour, String cuisine, String openHour, String id, String image_ref, Long wait, ArrayList<MenuItem> menu) {
        this.name = name;
        this.closeHour = closeHour;
        this.cuisine = cuisine;
        this.openHour = openHour;
        this.id = id;
        this.image_ref = image_ref;
        this.wait = wait;
        this.menuu = menu;
    }

    public Restaurant(){}

    protected Restaurant(Parcel in) {
        name = in.readString();
        closeHour = in.readString();
        cuisine = in.readString();
        openHour = in.readString();
        id = in.readString();
        image_ref = in.readString();
        if (in.readByte() == 0) {
            wait = null;
        } else {
            wait = in.readLong();
        }
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

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

    public String getOpenHour() {
        return openHour;
    }

    public String getId() {
        return id;
    }

    public ArrayList<MenuItem> getMenu() {
        return menuu;
    }

    public String getImage_ref() {
        return image_ref;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(closeHour);
        dest.writeString(cuisine);
        dest.writeString(openHour);
        dest.writeString(id);
        dest.writeString(image_ref);
        if (wait == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(wait);
        }
    }
}
