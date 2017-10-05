package com.login_signup_screendesign_demo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.graphics.Color.*;

public class Main3Activity extends AppCompatActivity {

    private String ques,q_user,q_tag,q_top;
    private String ans_text,ans_user,ans_tag;

    User_Info info;
    private TextView tv_ques,tv_q_user,tv_q_tag,tv_ans,tv_ans_tag,tv_ans_user,tv_top;

    ImageView upvote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("ANSWER_INFO");
        ques = bundle.getString("QUESTION");
        q_user = bundle.getString("Q_NAME");
        q_tag = bundle.getString("Q_TAG");
        q_top = bundle.getString("Q_Topic");
        ans_text = bundle.getString("ANSWER");
        ans_user = bundle.getString("A_USER");
        ans_tag = bundle.getString("A_TAG");
        info = (User_Info) bundle.getSerializable("Com_object");
        if(info!=null){
            Log.d("hello","inside main3:"+info.getEmail_id());
        }

        tv_ques = (TextView) findViewById(R.id.ques);
        tv_q_user = (TextView) findViewById(R.id.tv_name);
        tv_q_tag = (TextView) findViewById(R.id.tv_qual);
        tv_ans = (TextView) findViewById(R.id.answerIshere);
        tv_ans_user = (TextView) findViewById(R.id.tv_name1);
        tv_ans_tag = (TextView) findViewById(R.id.tv_qual1);
        tv_top = (TextView) findViewById(R.id.ques_title);
        upvote = (ImageView) findViewById(R.id.upvote);


        tv_ques.setText(ques);
        tv_q_user.setText(q_user);
        tv_q_tag.setText(q_tag);
        tv_top.setText(q_top);
        tv_ans.setText(ans_text);
        tv_ans_user.setText(ans_user);
        tv_ans_tag.setText(ans_tag);

        upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    DrawableCompat.setTint(upvote.getDrawable(), ContextCompat.getColor(getApplicationContext(),R.color.black));

//                upvote.setColorFilter(getResources().getColor(R.color.dark_greyish));
                DrawableCompat.setTint(upvote.getDrawable(), ContextCompat.getColor(getApplicationContext(),R.color.Red));
            }
        });


    }
}
