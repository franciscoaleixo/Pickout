package com.pcfa.thisorthat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";
    private TextView mTextMessage;
    private BottomNavigationViewEx bnve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.content_message);
        bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        setUpBottomNavigation(bnve);
    }

    public void setUpBottomNavigation(BottomNavigationViewEx bnve) {

        bnve.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //Dashboard
        bnve.setIconSizeAt(1,48,48);
        bnve.setIconMarginTop(1, BottomNavigationViewEx.dp2px(this, 4));
        bnve.enableShiftingMode(false);
        bnve.enableAnimation(false);
        bnve.setIconTintList(1, null);
        //Home
        bnve.setIconSizeAt(0,32,32);
        bnve.setIconMarginTop(0, BottomNavigationViewEx.dp2px(this, 12));
        bnve.setIconTintList(0,  getResources().getColorStateList(R.color.selector_item_gray_color));
        //User
        bnve.setIconSizeAt(2,32,32);
        bnve.setIconMarginTop(2, BottomNavigationViewEx.dp2px(this, 12));
        bnve.setIconTintList(2,  getResources().getColorStateList(R.color.selector_item_gray_color));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(UserActivity.TAG.equals(getIntent().getStringExtra("activityName"))) {
                        finish(); // TODO: Returns to the last view and not "home".. find solution
                    }

                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:

                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_user:

                    if(!UserActivity.TAG.equals(getIntent().getStringExtra("activityName"))) {
                        Intent userIntent = new Intent(MainActivity.this, UserActivity.class);
                        userIntent.putExtra("activityName", UserActivity.TAG);
                        startActivity(userIntent);
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    public void finish() {
        super.finish();
    }
}
