package com.example.windows.fooddeliveryapp.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.mainmenu.MainMenuNonVeg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainMenuActivity extends AppCompatActivity {

    @BindView(R.id.frame_main_menu)
    FrameLayout frameLayout;

    Fragment fragment;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportActionBar().setTitle(getResources().getString(R.string.string_main_course));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragment=MainMenuFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main_menu,fragment)
                .commit();

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
}
