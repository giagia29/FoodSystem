package com.example.foodsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cart implements Parcelable {
    ArrayList<MenuItem> items;
    double total = 0;
    long payment;
    Restaurant restaurant;
    String Method;

    public Cart(){}

    protected Cart(Parcel in) {
        items = in.createTypedArrayList(MenuItem.CREATOR);
        total = in.readDouble();
        payment = in.readLong();
        restaurant = in.readParcelable(Restaurant.class.getClassLoader());
        Method = in.readString();
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public long getPayment() {
        return payment;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
        dest.writeDouble(total);
        dest.writeLong(payment);
        dest.writeParcelable(restaurant, flags);
        dest.writeString(Method);
    }
}
