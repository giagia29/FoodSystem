package adapters;

import java.util.ArrayList;
import java.util.List;

import models.Food;

public class CartAdapter {
    public static List<Food> cart;

    public static List<Food> getCart(){
        if (cart == null)
            cart = new ArrayList<Food>();
        return cart;
    }

    public CartAdapter() {
    }

    public static void setCart(List<Food> cart) {
        CartAdapter.cart = cart;
    }
}
