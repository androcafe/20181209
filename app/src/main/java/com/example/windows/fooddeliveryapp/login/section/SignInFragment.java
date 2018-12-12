package com.example.windows.fooddeliveryapp.login.section;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows.fooddeliveryapp.LoginActivity;
import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.home.HomeActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SignInFragment extends Fragment {

    Unbinder unbinder;

    //define UI components
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;

    @BindView(R.id.tv_forgot_pw)
    TextView tvForgetPass;

    @BindView(R.id.tv_create_now)
    TextView tvCreateNow;

    @BindView(R.id.edt_phoneno)
    EditText edtPhoneNo;

    @BindView(R.id.edt_password)
    EditText edtPassword;

    @BindView(R.id.layout_sign_in2)
    LinearLayout linearLayoutSignIn;

    //Shared Preference
    SharedPreferences sharedPreferences;

    //Language Change
    Locale myLocale;


    //signUp fragment
    Fragment fragmentSignUp;

    public static String PHONENO="PhoneNo";


    public SignInFragment(){
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {

        Bundle args = new Bundle();

        SignInFragment fragment = new SignInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_signin,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        //Initializing Shared Preference
        sharedPreferences=getActivity().getSharedPreferences(HomeActivity.MyPref,Context.MODE_PRIVATE);

        //Click on Create Now textview
        tvCreateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentSignUp=SignUpFragment.newInstance();

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout_login,fragmentSignUp)
                        .commit();


            }
        });

        //onClickListener to button
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initializing Shared Preference
                sharedPreferences=getActivity().getSharedPreferences(HomeActivity.MyPref,Context.MODE_PRIVATE);

                //check whether language is set or not
                if(sharedPreferences.contains(HomeActivity.LANGUAGE))
                {
                    String lan= sharedPreferences.getString(HomeActivity.LANGUAGE,null);
                    System.out.println("localName "+lan);
                    if(lan.equals("mr"))
                    {
                        setLocale("mr");
                    }
                }

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(PHONENO,edtPhoneNo.getText().toString());
                editor.commit();

                Intent intentHome=new Intent(getActivity(), HomeActivity.class);
                startActivity(intentHome);
            }
        });


        //Click on forgot password text
        tvForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentSignUp=ForgotPassFragment.newInstance();

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout_login,fragmentSignUp)
                        .commit();


            }
        });

        return view;
    }

    public void setLocale(String localeName) {
        System.out.println("localName "+localeName);
        myLocale = new Locale(localeName);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(getActivity(), HomeActivity.class);
        refresh.putExtra(localeName, localeName);
        startActivity(refresh);

    }
}
