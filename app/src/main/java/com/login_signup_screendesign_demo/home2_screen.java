package com.login_signup_screendesign_demo;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class home2_screen extends Fragment {


    private String ques_txt,q_name,q_tag,q_topic;

    TextView question,tag,u_name,topic;

    private List<String> ans_text,user_name,user_tag;
    private List<Integer>aid;

    private int qid;

    final private String ROOT_URL = "https://wwwqueriuscom.000webhostapp.com/";
    final private String TAG = "Answer_Screen";

    User_Info info;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RelativeLayout relativeLayout;

    public home2_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home2_screen, container, false);

        ques_txt = getArguments().getString("QUESTION");
        q_name = getArguments().getString("NAME");
        q_tag = getArguments().getString("TAGLINE");
        q_topic = getArguments().getString("TOPIC");
        info = (User_Info) getArguments().getSerializable("Com_object");
        qid = getArguments().getInt("QUESTION ID");


            Log.d("hello","info inside home2 is :"+info);


        question = (TextView) v.findViewById(R.id.ques);
        u_name = (TextView) v.findViewById(R.id.tv_name);
        tag = (TextView) v.findViewById(R.id.tv_qual);
        topic = (TextView) v.findViewById(R.id.ques_title);

        question.setText(ques_txt);
        u_name.setText(q_name);
        tag.setText(q_tag);
        topic.setText(q_topic);


        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(home2_screen.this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        relativeLayout = (RelativeLayout) v.findViewById(R.id.hs_rel);

        ans_text= new ArrayList<>();
        user_name= new ArrayList<>();
        user_tag= new ArrayList<>();
        aid=new ArrayList<>();



        getAnswers();
        return v;
    }


    private void getAnswers(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
        AnswerAPI api = retrofit.create(AnswerAPI.class);

        Call<List<Answer_model>> model = api.get_all_ans(qid);

        model.enqueue(new Callback<List<Answer_model>>() {
            @Override
            public void onResponse(Call<List<Answer_model>> call, Response<List<Answer_model>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"Inside On Response");
                    List<Answer_model> list = response.body();
                    int i = list.size()-1;
                    while(i>=0){
                        ans_text.add(list.get(i).getAns_text());
                        user_name.add(list.get(i).getU_name());
                        user_tag.add(list.get(i).getU_tag());
                        aid.add(list.get(i).getAns_id());
                        i--;
                    }

                    adapter = new RecyclerViewAdapter(aid,ques_txt,q_name,q_tag,q_topic,ans_text, user_name, user_tag,home2_screen.this.getActivity(),info);
                    recyclerView.setAdapter(adapter);


                }
                else {
                    Log.d(TAG,"Inside onResponse else");
                }
            }

            @Override
            public void onFailure(Call<List<Answer_model>> call, Throwable t) {
                Log.d(TAG,"Inside onFailure");
                t.printStackTrace();
            }
        });

    }

}
