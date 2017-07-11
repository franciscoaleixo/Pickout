package com.pcfa.thisorthat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pcfa.thisorthat.R;
import com.pcfa.thisorthat.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dpswtf on 09/07/2017.
 */

public class LoginFragment extends Fragment {

    public static final String TAG = LoginFragment.class.getSimpleName();

    @BindView(R.id.loginBtn) Button loginButton;
    @BindView(R.id.reg_btn) Button regButton;
    @BindView(R.id.facebook_login) LinearLayout fbLogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        setUpClickListeners();


        return view;
    }

    private void setUpClickListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
        fbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Login with facebook
            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Register
            }
        });

    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginFragment.this.getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        LoginFragment.this.getActivity().finish();
    }



}
