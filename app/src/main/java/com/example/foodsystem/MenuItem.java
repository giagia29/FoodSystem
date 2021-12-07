package com.example.foodsystem;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    String name, description, prepTime, price;

    // Generated core to parce and load from firebase
    public MenuItem(){}
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getPrice() {
        return price;
    }
    protected MenuItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        prepTime = in.readString();
        price = in.readString();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(prepTime);
        dest.writeString(price);
    }
}
