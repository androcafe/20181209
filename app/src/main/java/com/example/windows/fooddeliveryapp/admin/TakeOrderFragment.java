package com.example.windows.fooddeliveryapp.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.adapter.AdminTakeOrderAdapter;
import com.example.windows.fooddeliveryapp.model.AdminTakeOrder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TakeOrderFragment extends Fragment {

    Unbinder unbinder;

    //define UI components
    @BindView(R.id.rl_admin_take_order)
    RecyclerView rlPastOrder;

    //Model class for order
    AdminTakeOrder adminTakeOrder;

    //ArrayList fot order
    ArrayList<AdminTakeOrder> arrayList=new ArrayList<>();

    //Past order adapter
    AdminTakeOrderAdapter adapter;

    public static TakeOrderFragment newInstance() {

        Bundle args = new Bundle();

        TakeOrderFragment fragment = new TakeOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.admin_take_order_fragment,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        //New Order recyclerview processsing
        adminTakeOrder=new AdminTakeOrder(100,"2018/2/2","Park Shin Hye","Seoul","500");
        arrayList.add(adminTakeOrder);

        adminTakeOrder=new AdminTakeOrder(100,"2018/2/2","Park Chanyeol","Busan","1500");
        arrayList.add(adminTakeOrder);

        //Initialize past order adapter
        adapter=new AdminTakeOrderAdapter(getActivity(),arrayList);

        //Initialize linear layout
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //set layout to relative layout
        rlPastOrder.setLayoutManager(linearLayoutManager);

        //set adapter to recyclerview
        rlPastOrder.setAdapter(adapter);


        return view;
    }
}
