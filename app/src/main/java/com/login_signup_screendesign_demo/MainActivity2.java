package com.login_signup_screendesign_demo;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

//    private TextView mTextMessage;

    User_Info userInfo;
    MenuItem menuItem;

    ImageView iview;
    Context context;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
//                    getIntent().putExtra("Com_object",userInfo);
                    Home_Fragment fragment123 = new Home_Fragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Com_object",userInfo);
                    fragment123.setArguments(bundle);
                    fragmentManager1.beginTransaction().replace(R.id.content,fragment123).commit();

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



        Intent intent = getIntent();
        userInfo = (User_Info) intent.getExtras().getSerializable("Object");
        Log.d("sab","inside M2"+userInfo.getName());
//        context = (Context) intent.getExtras().getSerializable("Context");



        FragmentManager fragmentManager2 = getSupportFragmentManager();
        Home_Fragment fragment123 = new Home_Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Com_object",userInfo);
        fragment123.setArguments(bundle);
        fragmentManager2.beginTransaction().replace(R.id.content,fragment123).commit();
//        if(userInfo != null) {
//            Log.d("User_info", "" + userInfo.getName());
//        }
        iview = (ImageView) findViewById(R.id.toggle);

        iview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), iview);
                dropDownMenu.getMenuInflater().inflate(R.menu.menu_drop_down, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.dropdown_menu1:
//                                SaveSharedPreference.setUserName(getApplicationContext(),"");
                                SaveSharedPreference.clearUserName(getApplicationContext());
                                Intent intent1 = new Intent(MainActivity2.this,MainActivity.class);
//                                Login_Fragment fragment = new Login_Fragment();
                                onDestroy();
                                startActivity(intent1);
                                return true;
                        }

//                        Toast.makeText(Profile_Fragment.this.getActivity(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                dropDownMenu.show();
            }

        });



//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public void onBackPressed() {



        Intent menuIntent = new Intent();
        menuIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
//        super.onBackPressed();
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


//
//class myHelper{
//
//    Context context;
//    public myHelper(Context context) {
//        this.context=context;
//    }
//
//    public Context get_con(){
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//}
