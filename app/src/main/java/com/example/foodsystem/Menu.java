package com.example.foodsystem;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem> items;

    // Creates a list of menu items from an id
    public Menu(String id){
        DatabaseReference database;
        database = FirebaseDatabase.getInstance().getReference("restaurants"+"/"+id+"/"+"menu");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MenuItem item = dataSnapshot.getValue(MenuItem.class);
                    items.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
