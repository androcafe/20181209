package com.example.windows.fooddeliveryapp.admin;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.categories.MainMenuActivity;
import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.mainmenu.MainMenuNonVeg;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminOrderActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    //This is our viewPager
    @BindView(R.id.pager)
    ViewPager viewPager;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);

        getSupportActionBar().setTitle(getResources().getString(R.string.string_admin_take_order));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // bind the view using butterknife
        ButterKnife.bind(this);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_new_order)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_past_order)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_cancel_order)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(AdminOrderActivity.this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    class Pager extends FragmentStatePagerAdapter {

        //integer to count number of tabs
        int tabCount;

        //Constructor to the class
        public Pager(FragmentManager fm, int tabCount) {
            super(fm);
            //Initializing tab count
            this.tabCount = tabCount;
        }

        //Overriding method getItem
        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    TakeOrderFragment takeOrderFragment = new TakeOrderFragment();
                    return takeOrderFragment;
                case 1:
                    MainMenuNonVeg mainMenuNonVeg1 = new MainMenuNonVeg();
                    return mainMenuNonVeg1;
                case 2:
                    MainMenuNonVeg mainMenuNonVeg2 = new MainMenuNonVeg();
                    return mainMenuNonVeg2;
                default:
                    return null;
            }
        }

        //Overriden method getCount to get the number of tabs
        @Override
        public int getCount() {
            return tabCount;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(AdminOrderActivity.this,HomeActivity.class);
                startActivity(intent);
                return true;
        }
        return  false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(AdminOrderActivity.this,HomeActivity.class);
        finish();
        startActivity(intent);
    }
}
