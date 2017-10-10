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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.graphics.Color.*;

public class Main3Activity extends AppCompatActivity {

    private String ques,q_user,q_tag,q_top,q_url;
    private String ans_text,ans_user,ans_tag,a_url;
    private int aid,qid,auid,quid;

    User_Info info;
    private TextView tv_ques,tv_q_user,tv_q_tag,tv_ans,tv_ans_tag,tv_ans_user,tv_top;

    ImageView upvote,give_ans;
    RoundedImageView ques_profile,ans_profile;

    final private String ROOT_URL = "http://192.168.1.4/sj/";

    LinearLayout linearLayout,linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("ANSWER_INFO");
        ques = bundle.getString("QUESTION");
        q_user = bundle.getString("Q_NAME");
        q_tag = bundle.getString("Q_TAG");
        q_url = bundle.getString("Q_IMAGE");
        a_url = bundle.getString("IMAGE");
        q_top = bundle.getString("Q_Topic");
        ans_text = bundle.getString("ANSWER");
        ans_user = bundle.getString("A_USER");
        ans_tag = bundle.getString("A_TAG");
        info = (User_Info) bundle.getSerializable("Com_object");
        aid=bundle.getInt("ANSWER ID");
        qid=bundle.getInt("QUESTION ID");
        quid=bundle.getInt("QUSER ID");
        auid=bundle.getInt("AUSER ID");
            Log.d("hello","inside main3:"+info);


        tv_ques = (TextView) findViewById(R.id.ques);
        tv_q_user = (TextView) findViewById(R.id.tv_name);
        tv_q_tag = (TextView) findViewById(R.id.tv_qual);
        tv_ans = (TextView) findViewById(R.id.answerIshere);
        tv_ans_user = (TextView) findViewById(R.id.tv_name1);
        tv_ans_tag = (TextView) findViewById(R.id.tv_qual1);
        tv_top = (TextView) findViewById(R.id.ques_title);
        upvote = (ImageView) findViewById(R.id.upvote);
        give_ans = (ImageView) findViewById(R.id.ans_btn);
        linearLayout = (LinearLayout) findViewById(R.id.user);
        linearLayout1 = (LinearLayout) findViewById(R.id.user1);
        ques_profile = (RoundedImageView) findViewById(R.id.logo1);
        ans_profile = (RoundedImageView) findViewById(R.id.logo2);


        tv_ques.setText(ques);
        tv_q_user.setText(q_user);
        tv_q_tag.setText(q_tag);
        tv_top.setText(q_top);
        tv_ans.setText(ans_text);
        tv_ans_user.setText(ans_user);
        tv_ans_tag.setText(ans_tag);

        Picasso.with(getApplicationContext()).load(ROOT_URL+q_url).into(ques_profile);
        Picasso.with(getApplicationContext()).load(ROOT_URL+a_url).into(ans_profile);

        upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    DrawableCompat.setTint(upvote.getDrawable(), ContextCompat.getColor(getApplicationContext(),R.color.black));

//                upvote.setColorFilter(getResources().getColor(R.color.dark_greyish));


                DrawableCompat.setTint(upvote.getDrawable(), ContextCompat.getColor(getApplicationContext(),R.color.Red));


                final Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
                answer_upvoteAPI upvoteAPI = retrofit.create(answer_upvoteAPI.class);

                Call<Integer> call = upvoteAPI.do_upvote(info.getUser_id(),aid);

                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Log.d("hello","Inside on upvote response");
                        int value=-1;
                        value=response.body();
                        if(value==1){

                            Toast.makeText(getApplicationContext(),"Upvoted",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Not Upvoted",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"Check Your Network",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        give_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Main4Activity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("QUESTION TEXT",ques);
                bundle1.putString("TOPIC NAME",q_top);
                bundle1.putString("Q_NAME",q_user);
                bundle1.putString("Q_TAGLINE",q_tag);
                bundle1.putSerializable("Com_object",info);
                bundle1.putInt("QUESTION ID",qid);
                intent1.putExtra("MAIN4",bundle1);
                startActivity(intent1);
            }
        });


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Other User","Inside Main3");
                Intent intent = new Intent(Main3Activity.this,Other_user.class);
                intent.putExtra("QUSER ID",quid);
                intent.putExtra("CURR_UID",info.getUser_id());
                startActivity(intent);
            }
        });


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Other User","Inside Main3");
                Intent intent = new Intent(Main3Activity.this,Other_user.class);
                intent.putExtra("QUSER ID",auid);
                intent.putExtra("CURR_UID",info.getUser_id());
                startActivity(intent);
            }
        });





    }
}
