package com.example.foodsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant implements Parcelable{
    String name, closeHour, cuisine, openHour, id;
    Long wait;
    ArrayList<MenuItem> menuu;

    public Restaurant(String name, String closeHour, String cuisine, String openHour, String id, Long wait, ArrayList<MenuItem> menu) {
        this.name = name;
        this.closeHour = closeHour;
        this.cuisine = cuisine;
        this.openHour = openHour;
        this.id = id;
        this.wait = wait;
        this.menuu = menu;
    }

    public Restaurant(){}
//    protected Restaurant(Parcel in) {
//        name = in.readString();
//        closeHour = in.readString();
//        cuisine = in.readString();
//        openHour = in.readString();
//        id = in.readString();
//        if (in.readByte() == 0) {
//            wait = null;
//        } else {
//            wait = in.readLong();
//        }
//        menu = in.readHashMap(null);
//    }

//    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
//        @Override
//        public Restaurant createFromParcel(Parcel in) {
//            return new Restaurant(in);
//        }
//
//        @Override
//        public Restaurant[] newArray(int size) {
//            return new Restaurant[size];
//        }
//    };


    protected Restaurant(Parcel in) {
        name = in.readString();
        closeHour = in.readString();
        cuisine = in.readString();
        openHour = in.readString();
        id = in.readString();
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

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(name);
//        dest.writeString(closeHour);
//        dest.writeString(cuisine);
//        dest.writeString(openHour);
//        dest.writeString(id);
//        if (wait == null) {
//            dest.writeByte((byte) 0);
//        } else {
//            dest.writeByte((byte) 1);
//            dest.writeLong(wait);
//        }
//        dest.writeMap(menu);
//    }

    public ArrayList<MenuItem> getMenu() {
        return menuu;
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
        if (wait == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(wait);
        }
    }
}
