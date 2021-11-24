package models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {
    String restaurant_name;
    String restaurant_phone;
    String address;
    public Restaurants()
    {}

    //Parsing the object from the data
    public Restaurants(JSONObject jsonObject) throws JSONException {
        restaurant_name = jsonObject.getString("restaurant_name");
        restaurant_phone = jsonObject.getString("restaurant_phone");
        address = jsonObject.getString("address");
    }

    public static List<Restaurants> fromJsonArray(JSONArray restaurantJsonArray) throws JSONException {

        List<Restaurants> restaurants = new ArrayList<>();
        for (int i = 0; i < restaurantJsonArray.length(); i++){
            restaurants.add(new Restaurants(restaurantJsonArray.getJSONObject(i)));
        }
        return restaurants;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public String getRestaurant_phone() {
        return restaurant_phone;
    }

    public String getAddress() {
        return address;
    }
}
