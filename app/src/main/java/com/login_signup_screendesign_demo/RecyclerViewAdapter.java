package com.login_signup_screendesign_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shantanu on 4/10/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<String> ans_list,user_name,user_tagline;
    private List<Integer>ans_id;
    Integer qid;
    Context context;
    User_Info info;

    private String ques,q_user,q_tag,q_top;

    public RecyclerViewAdapter(Integer qid,List<Integer> ans_id,String ques,String q_user,String q_tag,String q_top,List<String> ans_list, List<String> user_name, List<String> user_tagline, Context context,User_Info info) {
        this.ques=ques;
        this.q_user=q_user;
        this.q_tag=q_tag;
        this.q_top=q_top;
        this.ans_list = ans_list;
        this.user_name = user_name;
        this.user_tagline = user_tagline;
        this.ans_id=ans_id;
        this.context=context;
        this.info=info;
        this.qid=qid;
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_answers, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        holder.tv_ans.setText(ans_list.get(position));
        holder.tv_name.setText(user_name.get(position));
        holder.tv_qual.setText(user_tagline.get(position));

        holder.iview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main3Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("QUESTION",ques);
                bundle.putString("Q_NAME",q_user);
                bundle.putString("Q_TAG",q_tag);
                bundle.putString("Q_Topic",q_top);
                bundle.putString("ANSWER",ans_list.get(position));
                bundle.putString("A_USER",user_name.get(position));
                bundle.putString("A_TAG",user_tagline.get(position));
                bundle.putSerializable("Com_object",info);
                bundle.putInt("ANSWER ID",ans_id.get(position));
                bundle.putInt("QUESTION ID",qid);
                intent.putExtra("ANSWER_INFO",bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ans_list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{


        TextView tv_ans,tv_name,tv_qual;
        ImageView iview;
        RoundedImageView imageView;
        FragmentCommunication mCommunication;
        public ViewHolder(View itemView) {
            super(itemView);

            tv_ans = (TextView) itemView.findViewById(R.id.answer);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_qual = (TextView) itemView.findViewById(R.id.tv_qual);
            imageView = (RoundedImageView) itemView.findViewById(R.id.logo_in_answer);
            iview = (ImageView) itemView.findViewById(R.id.btn_show_ans);

        }
    }
}
