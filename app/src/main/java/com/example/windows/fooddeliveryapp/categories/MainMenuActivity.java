package com.example.windows.fooddeliveryapp.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.admin.AdminOrderActivity;
import com.example.windows.fooddeliveryapp.admin.TakeOrderFragment;
import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.mainmenu.MainMenuNonVeg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMenuActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    @BindView(R.id.tabLayout_main_menu)
    TabLayout tabLayout;

    //This is our viewPager
    @BindView(R.id.pager_main_menu)
    ViewPager viewPager;

    Fragment fragment;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportActionBar().setTitle(getResources().getString(R.string.string_main_course));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // bind the view using butterknife
        ButterKnife.bind(this);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.string_veg)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.string_non_veg)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(MainMenuActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(MainMenuActivity.this,HomeActivity.class);
                startActivity(intent);
                return true;
        }
        return  false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MainMenuActivity.this,HomeActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

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
                    TabLayout.Tab tab = tabLayout.getTabAt(0);
                    tab.select();
                    MainMenuNonVeg mainMenuNonVeg = new MainMenuNonVeg();
                    return mainMenuNonVeg;
                case 1:
                    TabLayout.Tab tab1 = tabLayout.getTabAt(1);
                    tab1.select();
                    MainMenuNonVeg mainMenuNonVeg1 = new MainMenuNonVeg();
                    return mainMenuNonVeg1;
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
}
