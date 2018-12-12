package com.example.windows.fooddeliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.ivLogo)
    ImageView ivLOgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // bind the view using butterknife
        ButterKnife.bind(this);

        Animation animation= AnimationUtils.loadAnimation(SplashScreen.this,
                R.anim.splash_screen_anim);
        ivLOgo.startAnimation(animation);

        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    //Start Login Activity
                    Intent intentLogin=new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(intentLogin);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }
}
