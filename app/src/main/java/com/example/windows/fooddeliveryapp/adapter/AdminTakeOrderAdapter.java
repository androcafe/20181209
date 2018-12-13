package com.example.windows.fooddeliveryapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.model.AdminTakeOrder;
import com.example.windows.fooddeliveryapp.model.MenuModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminTakeOrderAdapter extends RecyclerView.Adapter<AdminTakeOrderAdapter.MyViewHolder> {
    ArrayList<AdminTakeOrder> arrayList;
    Context context;

    LayoutInflater inflater;

    public AdminTakeOrderAdapter(FragmentActivity activity, ArrayList<AdminTakeOrder> arrayList) {
        context=activity;
        this.arrayList=arrayList;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdminTakeOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.rl_admin_take_order_row,null);
        return new AdminTakeOrderAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdminTakeOrderAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvName.setText(arrayList.get(i).getName());
        myViewHolder.tvId.setText(""+arrayList.get(i).getId());
        myViewHolder.tvDate.setText(arrayList.get(i).getDate());
        myViewHolder.tvAddress.setText(arrayList.get(i).getAddress());
        myViewHolder.tvTotal.setText(arrayList.get(i).getTotal());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_order_id)
        TextView tvId;

        @BindView(R.id.tv_order_address)
        TextView tvAddress;

        @BindView(R.id.tv_date)
        TextView tvDate;

        @BindView(R.id.tv_total)
        TextView tvTotal;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // binding view
            ButterKnife.bind(this, itemView);
        }
    }

}
