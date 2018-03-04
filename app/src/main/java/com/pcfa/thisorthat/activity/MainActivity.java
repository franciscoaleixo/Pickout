package com.pcfa.thisorthat.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.pcfa.thisorthat.R;
import com.pcfa.thisorthat.adapter.ScreenSlidePagerAdapter;
import com.pcfa.thisorthat.fragment.HomeFragment;
import com.pcfa.thisorthat.fragment.NewSurveyFragment;
import com.pcfa.thisorthat.fragment.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        NewSurveyFragment.OnFragmentInteractionListener, UserFragment.OnFragmentInteractionListener{

    public static String TAG = "MainActivity";

    private ViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;

    //NewSurveyFragment
    private int REQUEST_CAMERA = 0;
    private int SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        setUpBottomNavigation(bnve);
        setUpViewPager();
    }

    private void setUpViewPager() {
        mPager = (ViewPager) findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(NewSurveyFragment.newInstance());
        fragments.add(UserFragment.newInstance());

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mPagerAdapter);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_user:
                    mPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void cameraIntent(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    // TODO: gallery on NewSurveyFragmentlayout
    public void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }
}
