package com.example.windows.fooddeliveryapp.login.section;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.windows.fooddeliveryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ForgotPassFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.edt_phone_no)
    EditText editTextPhone;

    @BindView(R.id.btn_submit)
    Button buttonSubmit;

    @BindView(R.id.ib_back_arrow)
    ImageButton ibBackButton;

    Fragment fragmentSignIn;


    public ForgotPassFragment() {
    }

    public static ForgotPassFragment newInstance() {

        Bundle args = new Bundle();

        ForgotPassFragment fragment = new ForgotPassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragement_forgot_password,null);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        ibBackButton.setOnClickListener(new View.OnClickListener() {
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
