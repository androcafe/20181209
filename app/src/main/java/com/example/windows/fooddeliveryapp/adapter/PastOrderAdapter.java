package com.example.windows.fooddeliveryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.model.PastOrderModel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PastOrderAdapter extends RecyclerView.Adapter<PastOrderAdapter.MyViewHolder> {

    Context context;
    ArrayList<PastOrderModel> pastOrderModelList;

    LayoutInflater inflater;

    //Rs sign
    String rs="\u20B9";
    byte[] utf8 = null;

    public PastOrderAdapter(FragmentActivity activity, ArrayList<PastOrderModel> arrayList) {
        context=activity;
        pastOrderModelList=arrayList;

        inflater=LayoutInflater.from(context);

        try {
            utf8 = rs.getBytes("UTF-8");
            rs = new String(utf8, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.rl_past_order_row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(pastOrderModelList.get(i).getOrder_status().equals("Delivered"))
        {
            myViewHolder.tvOrderStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }
        else
        {
            myViewHolder.tvOrderStatus.setTextColor(context.getResources().getColor(R.color.colorRed));
        }
         myViewHolder.tvOrderName.setText(pastOrderModelList.get(i).getOrder_name());
         myViewHolder.tvOrderAT.setText(pastOrderModelList.get(i).getOrder_at());
         myViewHolder.tvOrderStatus.setText(pastOrderModelList.get(i).getOrder_status());
         myViewHolder.tvTotal.setText(""+rs+" "+pastOrderModelList.get(i).getOrder_total());
    }

    @Override
    public int getItemCount() {
        return pastOrderModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_order_name)
        TextView tvOrderName;

        @BindView(R.id.tv_order_total)
        TextView tvTotal;

        @BindView(R.id.tv_order_at)
        TextView tvOrderAT;

        @BindView(R.id.tv_order_status)
        TextView tvOrderStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // binding view
            ButterKnife.bind(this, itemView);
        }
    }
}
