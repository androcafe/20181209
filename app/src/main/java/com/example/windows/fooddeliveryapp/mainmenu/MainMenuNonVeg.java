package com.example.windows.fooddeliveryapp.mainmenu;

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
import com.example.windows.fooddeliveryapp.adapter.MenuNonVegModelAdapter;
import com.example.windows.fooddeliveryapp.model.MenuModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainMenuNonVeg extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.rl_menu_nonveg)
    RecyclerView rvMainMenuNonVeg;

    MenuModel menuModel;

    ArrayList<MenuModel> arrayList=new ArrayList<>();

    MenuNonVegModelAdapter menuNonVegModelAdapter;


    public static MainMenuNonVeg newInstance() {

        Bundle args = new Bundle();

        MainMenuNonVeg fragment = new MainMenuNonVeg();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu_nonveg,null);

        unbinder= ButterKnife.bind(this, view);

        menuModel=new MenuModel("Aloo Jira",100,0);
        arrayList.add(menuModel);

        menuModel=new MenuModel("Paneer Makhani",180,0);
        arrayList.add(menuModel);
        //Initialize linear layout
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvMainMenuNonVeg.setLayoutManager(linearLayoutManager);

        menuNonVegModelAdapter= new MenuNonVegModelAdapter(getActivity(),arrayList);

        rvMainMenuNonVeg.setAdapter(menuNonVegModelAdapter);
        return view;
    }
}

