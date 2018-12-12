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
import com.example.windows.fooddeliveryapp.model.MenuModel;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuNonVegModelAdapter extends RecyclerView.Adapter<MenuNonVegModelAdapter.MyViewHolder> {

    ArrayList<MenuModel> arrayList;
    Context context;

    LayoutInflater inflater;

    int qty=0;

    public MenuNonVegModelAdapter(FragmentActivity activity, ArrayList<MenuModel> arrayList) {

        context = activity;
        this.arrayList = arrayList;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.menu_list_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.tvMenu.setText(arrayList.get(i).getMenu_name());
        myViewHolder.tvPrice.setText(""+arrayList.get(i).getMenu_price());
       // myViewHolder.tvQty.setText(""+arrayList.get(i).getQty());

        myViewHolder.tvQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myViewHolder.tvQty.setTextColor(Color.BLACK);
                myViewHolder.tvQty.setText("");

                myViewHolder.tvAdd.setText(context.getResources().getString(R.string.string_add_sign));
                myViewHolder.tvSub.setText(context.getResources().getString(R.string.string_sub_sign));
                myViewHolder.tvAdd.setEnabled(true);
                myViewHolder.tvSub.setEnabled(true);
            }
        });

        myViewHolder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewHolder.tvQty.getText().equals(""))
                  qty=1;
                else
                    qty=Integer.parseInt(myViewHolder.tvQty.getText().toString())+1;

                myViewHolder.tvQty.setText(""+qty);

            }
        });

        myViewHolder.tvSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewHolder.tvQty.getText().equals("")||myViewHolder.tvQty.getText().equals("0"))
                    qty=0;
                else
                    qty=Integer.parseInt(myViewHolder.tvQty.getText().toString())-1;

                myViewHolder.tvQty.setText(""+qty);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_menu_name)
        TextView tvMenu;

        @BindView(R.id.tv_menu_price)
        TextView tvPrice;

        @BindView(R.id.tv_menu_qty)
        TextView tvQty;

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
