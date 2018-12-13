package com.example.windows.fooddeliveryapp.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.windows.fooddeliveryapp.LoginActivity;
import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.SplashScreen;
import com.example.windows.fooddeliveryapp.adapter.SliderPagerAdapter;
import com.example.windows.fooddeliveryapp.categories.MainMenuActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static java.lang.Thread.sleep;

public class HomeFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.fl_main_course)
    FrameLayout flMainCourse;

    //Language Change
    Locale myLocale;
    String currentLanguage = "en", currentLang;

    //Fragment
    Fragment fragment;

    @BindView(R.id.vp_slider)
    ViewPager vp_slider;

    SliderPagerAdapter sliderPagerAdapter;

    @BindView(R.id.ll_dots)
    LinearLayout ll_dots;
    ArrayList<Integer> slider_image_list= new ArrayList<>();;
    int page_position = 0;

    Handler handler;
    Thread thread;
    Boolean suspend=false;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(thread!=null)
        {
            thread.resume();
            suspend=false;
            initViewPager();
        }

    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        initViewPager();

        /*handler = new Handler();

        //TODO : ViewPager Duration handler
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(!suspend)
                    {
                        sleep(5000);
                        if (page_position == slider_image_list.size()) {
                            page_position = 0;
                        } else {
                            page_position = page_position + 1;
                        }
                        vp_slider.setCurrentItem(page_position, true);
                    }
                    else
                    {
                        wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();*/

        flMainCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getActivity(),MainMenuActivity.class);
               getActivity().finish();
               startActivity(intent);

            }
        });

        return view;
    }

    private void initViewPager() {

        slider_image_list.add(R.raw.prawnrice);
        slider_image_list.add(R.raw.mexicanchickentortillasoup);
        slider_image_list.add(R.raw.malaysianlaksa);
        slider_image_list.add(R.raw.seafoodpaella);
        slider_image_list.add(R.raw.garlicprawn);

        sliderPagerAdapter = new SliderPagerAdapter(getActivity(), slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);


        //TODO :  SLider image listener
        vp_slider.addOnPageChangeListener (new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                dots[i].setText(Html.fromHtml("&#8226;",Html.FROM_HTML_MODE_LEGACY));
            } else {
                dots[i].setText(Html.fromHtml("&#8226;"));
            }
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

    public boolean isSuspended()
    {
            suspend=true;
            return  true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // isSuspended();
       // this.getActivity().getFragmentManager().beginTransaction().addToBackStack(null);
    }
}
