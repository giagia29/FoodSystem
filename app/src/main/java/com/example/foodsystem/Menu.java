package com.example.foodsystem;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu implements Parcelable {
    ArrayList<MenuItem> items;
    public static final String TAG = "menu";
    DatabaseReference database;
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public Menu(){}
    // Creates a list of menu items from an id
    public Menu(String id){
        database = FirebaseDatabase.getInstance().getReference("restaurants/PandaE/menu");

        ValueEventListener event = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue() == null){
                }
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MenuItem item = dataSnapshot.getValue(MenuItem.class);
                    items.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: ");
            }
        };
        database.addValueEventListener(event);
    }

    protected Menu(Parcel in) {
        items = in.createTypedArrayList(MenuItem.CREATOR);
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }
}
