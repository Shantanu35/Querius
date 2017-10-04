package com.login_signup_screendesign_demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class home2_screen extends Fragment {


    private String ques_txt,q_name,q_tag,q_topic;

    TextView question,tag,u_name,topic;

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


        question = (TextView) v.findViewById(R.id.ques);
        u_name = (TextView) v.findViewById(R.id.tv_name);
        tag = (TextView) v.findViewById(R.id.tv_qual);
        topic = (TextView) v.findViewById(R.id.ques_title);

        question.setText(ques_txt);
        u_name.setText(q_name);
        tag.setText(q_tag);
        topic.setText(q_topic);


        return v;
    }

}
