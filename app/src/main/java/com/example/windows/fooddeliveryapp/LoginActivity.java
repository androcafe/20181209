package com.example.windows.fooddeliveryapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;


import com.example.windows.fooddeliveryapp.home.HomeActivity;
import com.example.windows.fooddeliveryapp.login.section.SignInFragment;

import java.util.Locale;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

    //Define UI componenets
    @BindView(R.id.framelayout_login)
    FrameLayout frameLayoutLogin;

    //Fragemnets for login and logout page
    Fragment fragmentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set default fragment to sign in page
        fragmentLogin= SignInFragment.newInstance();
        loadFragment(fragmentLogin);

    }

    private void loadFragment(Fragment fragmentLogin) {
        if (fragmentLogin != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout_login,fragmentLogin)
                    .commit();
        }
    }

}
