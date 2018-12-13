package com.example.windows.fooddeliveryapp.order;

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
import com.example.windows.fooddeliveryapp.adapter.PastOrderAdapter;
import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.model.PastOrderModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PastOrderFragement extends Fragment {

    Unbinder unbinder;

    //define UI components
    @BindView(R.id.rl_past_order)
    RecyclerView rlPastOrder;

    //Model class for past order
    PastOrderModel pastOrderModel;

    //ArrayList fotr past order
    ArrayList<PastOrderModel> arrayList=new ArrayList<>();

    //Past order adapter
    PastOrderAdapter pastOrderAdapter;

    public static PastOrderFragement newInstance() {

        Bundle args = new Bundle();

        PastOrderFragement fragment = new PastOrderFragement();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_past_order,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        // Set title bar
        ((HomeActivity) getActivity())
                .setActionBarTitle(getResources().getString(R.string.string_past_order));

        //Past Order recyclerview processsing
        pastOrderModel=new PastOrderModel("Margarita Pizza","2018/12/7","500","Delivered");
        arrayList.add(pastOrderModel);

        pastOrderModel=new PastOrderModel("Grilled Chicken with mole sauce","2018/12/7","600","Not Delivered");
        arrayList.add(pastOrderModel);

        //Initialize past order adapter
        pastOrderAdapter=new PastOrderAdapter(getActivity(),arrayList);

        //Initialize linear layout
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //set layout to relative layout
        rlPastOrder.setLayoutManager(linearLayoutManager);

        //set adapter to recyclerview
        rlPastOrder.setAdapter(pastOrderAdapter);


        return view;
    }
}
