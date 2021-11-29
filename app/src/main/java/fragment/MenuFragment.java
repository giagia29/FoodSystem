package fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.foodsystem.R;
import com.example.foodsystem.RestaurantDetail;

import java.util.ArrayList;
import java.util.List;

import adapters.CartAdapter;
import adapters.FoodAdapter;
import models.Food;


public class MenuFragment extends Fragment {

    RecyclerView rvMenu;
    View mView;
    RestaurantDetail restaurantDetail;
    FoodAdapter foodAdapter;
    IsendDataListener isendDataListener;


    public interface IsendDataListener{
        void sendData(String fname, String fprice);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        isendDataListener = (IsendDataListener) getActivity();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }


     /* Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.*/

    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_menu, container, false);

        rvMenu = mView.findViewById(R.id.rvMenu);
        restaurantDetail = (RestaurantDetail) getActivity();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(restaurantDetail);
        rvMenu.setLayoutManager(linearLayoutManager);

        foodAdapter = new FoodAdapter();
        foodAdapter.setData(getListFood(), new FoodAdapter.IClickAddtoCartListener() {
            @Override
            public void onClickAddtoCart(ImageView imgAddtoCart, Food food) {
                restaurantDetail.setCountItemInCart(restaurantDetail.getOrderCount() + 1);
                if (food != null)
                {
                    sendDatatoOrder(food);
                }

            }
        });
        rvMenu.setAdapter(foodAdapter);

        return mView;
    }


    private void sendDatatoOrder(Food food) {
        String food_name = food.getFname().toString().trim();
        String food_price = food.getFprice().toString().trim();
        if (food_name != null && food_price != null) {
            isendDataListener.sendData(food_name, food_price);
        }
    }
    /*private void sendDatatoOrder(List<Food> cart) {
        if (cart != null) {
            isendDataListener.sendData(cart);
        }
    }*/

    private List<Food> getListFood() {
        List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.orange_chicken, "Orange Chicken", "$4.50"));
        list.add(new Food(R.drawable.fried_rice, "Fried Rice", "$3.50"));
        list.add(new Food(R.drawable.shanghai_steak, "Shanghai Steak", "$5.50"));
        list.add(new Food(R.drawable.chow_mein, "Chow Mein", "$3.50"));
        list.add(new Food(R.drawable.chicken_teriyaki, "Chicken Teriyaki", "$5.50"));
        list.add(new Food(R.drawable.meatball_pasta, "Meatballs Spaghetti", "$6.75"));
        return list;
    }
}