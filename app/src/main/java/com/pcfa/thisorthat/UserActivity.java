package com.pcfa.thisorthat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by PaulaChen on 7/2/2017.
 */
    public class UserActivity extends MainActivity {

    public static String TAG = "UserActivity";
    private BottomNavigationViewEx user_bnve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        user_bnve = (BottomNavigationViewEx) findViewById(R.id.user_bnve);
        setUpBottomNavigation(user_bnve);

        //TODO: Create GridViewAdapter (?)
    }


    @Override
    public void finish() {
        super.finish();
    }
}
