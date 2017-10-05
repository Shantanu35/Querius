package com.login_signup_screendesign_demo;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity{

//    private TextView mTextMessage;

    User_Info userInfo;
    MenuItem menuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    getIntent().putExtra("Com_object",userInfo);
                    fragmentManager1.beginTransaction().replace(R.id.content,new Home_Fragment()).commit();

                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_profile);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    getIntent().putExtra("Com_object",userInfo);
                    android.support.v4.app.Fragment fragment = new android.support.v4.app.Fragment();
                    fragmentManager.beginTransaction().replace(R.id.content,new Profile_Fragment()).commit();
                    return true;

                case  R.id.ask_ques:
                    FragmentManager fragmentManager2 = getSupportFragmentManager();
                    getIntent().putExtra("Com_object",userInfo);
                    fragmentManager2.beginTransaction().replace(R.id.content,new ques_ask()).commit();
                    return true;
            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        getIntent().putExtra("Com_object",userInfo);
        fragmentManager2.beginTransaction().replace(R.id.content,new Home_Fragment()).commit();

        Intent intent = getIntent();
        userInfo = (User_Info) intent.getExtras().getSerializable("Object");
//        if(userInfo != null) {
//            Log.d("User_info", "" + userInfo.getName());
//        }

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


//    @Override
//    public void doSomething(User_Info info) {
//        userInfo = info;
//        if(userInfo != null) {
//            Log.d("M2", "" + userInfo.getName());
//        }
//
//    }
}
