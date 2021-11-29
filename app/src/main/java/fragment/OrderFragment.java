package fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.foodsystem.R;

import java.util.List;

import models.Food;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    TextView foodname;
    TextView foodprice;
    //ListView orderlist;
    //public List<Food> items_buy;
    View mOrderview;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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

        mOrderview = inflater.inflate(R.layout.fragment_order, container, false);

        //orderlist = mOrderview.findViewById(R.id.list_item);
        foodname = mOrderview.findViewById(R.id.f_name);
        foodprice = mOrderview.findViewById(R.id.f_price);
        /*ArrayAdapter<Food> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items_buy);
        if (adapter != null)
        {
            orderlist.setAdapter(adapter);
        }*/

        return mOrderview;
    }

    public void receiveData(String fname, String fprice){
        foodname.setText(fname);
        foodprice.setText(fprice);
    }
    /*public void receiveData(List<Food> cart){
        items_buy = cart;
    }*/
}