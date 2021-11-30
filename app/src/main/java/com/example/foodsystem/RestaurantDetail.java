package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.util.List;

import adapters.Cart;
import adapters.ViewPagerAdapter;
import fragment.MenuFragment;
import fragment.OrderFragment;
import models.Food;

public class RestaurantDetail extends AppCompatActivity implements MenuFragment.IsendDataListener {
//public class RestaurantDetail extends AppCompatActivity{
    TextView res_title;
    AHBottomNavigation ahBottomNavigation;
    AHBottomNavigationViewPager ahBottomNavigationViewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Cart> cartList;
    int OrderCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        res_title = findViewById(R.id.res_title);
        String rname = getIntent().getStringExtra("Restaurant's name");
        res_title.setText(rname);

        ahBottomNavigation = findViewById(R.id.AHBottomNavigation);
        ahBottomNavigationViewPager = findViewById(R.id.AHBottomNavigationViewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ahBottomNavigationViewPager.setAdapter(viewPagerAdapter);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.baseline_list_black_24, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.baseline_shopping_cart_black_24, R.color.color_tab_2);


        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                ahBottomNavigationViewPager.setCurrentItem(position);
                return true;
            }
        });

        ahBottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ahBottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setCountItemInCart(int countItemInCart){
        OrderCount = countItemInCart;
        AHNotification notification = new AHNotification.Builder()
                .setText(String.valueOf(countItemInCart))
                .setBackgroundColor(ContextCompat.getColor(RestaurantDetail.this, R.color.red))
                .setTextColor(ContextCompat.getColor(RestaurantDetail.this, R.color.white))
                .build();
        ahBottomNavigation.setNotification(notification, 1);
    }

    public int getOrderCount() {
        return OrderCount;
    }

    public List<Cart> getCartList(){
        return cartList;
    }

    public void sendData(List<Cart> cart) {
        OrderFragment orderFragment = (OrderFragment) getSupportFragmentManager().findFragmentById(R.id.orderfrag);
        orderFragment.receiveData(cart);
    }
}