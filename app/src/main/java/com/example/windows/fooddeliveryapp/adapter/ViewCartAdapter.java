package com.example.windows.fooddeliveryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.cart.ViewCartActivity;
import com.example.windows.fooddeliveryapp.model.ViewCart;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewCartAdapter extends RecyclerView.Adapter<ViewCartAdapter.MyViewHolder>{

    ArrayList<ViewCart> arrayList;
    Context context;

    LayoutInflater inflater;

    public ViewCartAdapter(ViewCartActivity viewCartActivity, ArrayList<ViewCart> arrayList) {
        context=viewCartActivity;
        this.arrayList=arrayList;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.rl_view_order_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getItem_name());
        holder.tvSubTotal.setText(arrayList.get(position).getPrice());
        holder.tvQty.setText(arrayList.get(position).getQty());
        if(arrayList.get(position).getItem_type().equals("veg"))
        {
            holder.ivItemType.setBackgroundResource(R.drawable.veg);
        }
        else
        {
            holder.ivItemType.setBackgroundResource(R.drawable.nonveg);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_item_name)
        TextView tvName;

        @BindView(R.id.tv_item_qty)
        TextView tvQty;

        @BindView(R.id.iv_item_type)
        ImageView ivItemType;

        @BindView(R.id.tv_subtotal)
        TextView tvSubTotal;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // binding view
            ButterKnife.bind(this, itemView);
        }
    }
}
