package com.example.windows.fooddeliveryapp.login.section;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.windows.fooddeliveryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SignUpFragment extends Fragment {

    Unbinder unbinder;

    //Declaration of UI components
    @BindView(R.id.iv_close)
    ImageButton ivClose;

    @BindView(R.id.layout_sign_up2)
    LinearLayout linearLayoutSignUP;

    //signUp fragment
    Fragment fragmentSignIn;

    //Location Spinner
    @BindView(R.id.spinner_loc)
    Spinner spinnerLoc;

    //Location
    String[] arrLoc={"Shirur Anantpal","Nagewadi","Turukwadi","Klamgav"};

    //ArrayAdapter for spinner
    ArrayAdapter<String> arrayAdapter;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance() {

        Bundle args = new Bundle();

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("RestrictedApi")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_signup,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        Animation animation= AnimationUtils.loadAnimation(getActivity(),
                R.anim.login_bg);
        linearLayoutSignUP.startAnimation(animation);

        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrLoc);
        spinnerLoc.setAdapter(arrayAdapter);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentSignIn=SignInFragment.newInstance();

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout_login,fragmentSignIn)
                        .commit();
            }
        });

       return view;
    }
}
