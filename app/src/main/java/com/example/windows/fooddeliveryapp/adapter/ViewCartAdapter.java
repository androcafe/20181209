package com.example.windows.fooddeliveryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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

    int qty=0;

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.tvName.setText(arrayList.get(position).getItem_name());
        holder.tvSubTotal.setText(arrayList.get(position).getPrice());
        holder.tvQty.setText(arrayList.get(position).getQty());
        if(arrayList.get(position).getItem_type().equals("veg"))
        {
            holder.ivItemType.setBackgroundResource(R.drawable.veg);
        }
        if(arrayList.get(position).getItem_type().equals("nonveg"))
        {
            holder.ivItemType.setBackgroundResource(R.drawable.nonveg);
        }

        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty=Integer.parseInt(holder.tvQty.getText().toString())+1;
                holder.tvQty.setText(""+qty);

            }
        });

        holder.tvSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.tvQty.getText().toString().equals("0"))
                    qty=0;
                else
                    qty=Integer.parseInt(holder.tvQty.getText().toString())-1;

                holder.tvQty.setText(""+qty);
            }
        });

        holder.tvQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 int res= Integer.parseInt(holder.tvQty.getText().toString())
                         *Integer.parseInt(arrayList.get(position).getPrice());

                holder.tvSubTotal.setText(""+res);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


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

        @BindView(R.id.tv_add)
        TextView tvAdd;

        @BindView(R.id.tv_sub)
        TextView tvSub;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // binding view
            ButterKnife.bind(this, itemView);
        }
    }
}
