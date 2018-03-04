package com.pcfa.thisorthat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.pcfa.thisorthat.R;
import com.pcfa.thisorthat.database.connection.ConnectionUsers;
import com.pcfa.thisorthat.fragment.LoginFragment;
import com.pcfa.thisorthat.utils.ErrorUtils;
import com.pcfa.thisorthat.utils.UserUtils;

/**
 * Created by PaulaChen on 7/2/2017.
 */
    public class LoginActivity extends AppCompatActivity {

    public static String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        // Verify login
        if(UserUtils.isLoggedIn(getApplicationContext())){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            LoginFragment fragment = LoginFragment.newInstance();
            addFragment(fragment, LoginFragment.TAG);
        }

        ConnectionUsers connection = new ConnectionUsers();
    }


    private void addFragment(Fragment newFragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(tag == null) {
            transaction.replace(R.id.main, newFragment);
        }else{
            transaction.replace(R.id.main, newFragment, tag);
        }
        //transaction.addToBackStack(tag);

        try {
            if(!isFinishing()){
                transaction.commit();
            }
        }catch (IllegalStateException ex){
            ErrorUtils.handleException(TAG, ex, "IllegalStateException committing fragment");
            try {
                transaction.commitAllowingStateLoss();
            }catch (IllegalStateException iex){
                ErrorUtils.handleException(TAG, iex, "IllegalStateException committing fragment allowing state loss");
            }
        }
    }

}
