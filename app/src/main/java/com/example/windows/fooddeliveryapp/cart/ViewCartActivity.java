package com.example.windows.fooddeliveryapp.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.adapter.ViewCartAdapter;
import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.model.ViewCart;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewCartActivity extends AppCompatActivity {

    @BindView(R.id.rl_recent_order)
    RecyclerView rlRecentOrder;

    /* Model class*/
    ViewCart viewCart;

    //ArrayList to save order
    ArrayList<ViewCart> arrayList=new ArrayList<>();

    //Adapter to recyclerview
    ViewCartAdapter viewCartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_cart));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // bind the view using butterknife
        ButterKnife.bind(this);

        viewCart=new ViewCart("veg","Aloo Jira","1","100");
        arrayList.add(viewCart);

        viewCart=new ViewCart("nonveg","Chicken Vindaloo","1","200");
        arrayList.add(viewCart);

        //Initialize linear layout
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ViewCartActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rlRecentOrder.setLayoutManager(linearLayoutManager);

        viewCartAdapter=new ViewCartAdapter(ViewCartActivity.this,arrayList);

        rlRecentOrder.setAdapter(viewCartAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(ViewCartActivity.this,HomeActivity.class);
                startActivity(intent);
                return true;
        }
        return  false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ViewCartActivity.this,HomeActivity.class);
        finish();
        startActivity(intent);
    }
}
