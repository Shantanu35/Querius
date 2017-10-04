package com.login_signup_screendesign_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shantanu on 1/10/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<String> ques_list,user_name,user_tagline,topic_name;

//    private List<Integer> user_id;
//
//    private List<get_detailed_fromQues> list;

    private List<String> user_image;

    private FragmentManager manager;


    RecyclerView recyclerView;

    FragmentCommunication communication;


//    final private String ROOT_URL = "https://wwwqueriuscom.000webhostapp.com/";
//    final private String TAG = "Adapter";


    public RecyclerAdapter(List<String> ques_list, List<String> user_name, List<String> user_tagline, List<String> user_image, List<String> topic_name, FragmentManager manager,RecyclerView recyclerView,FragmentCommunication communication) {
        this.ques_list = ques_list;
        this.user_name = user_name;
        this.user_tagline = user_tagline;
        this.user_image = user_image;
        this.topic_name = topic_name;
        this.manager = manager;
        this.recyclerView=recyclerView;
        this.communication=communication;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_screen_layout, parent, false);


//
//        getQues();
//
//        get_user_info();

        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_ques.setText(ques_list.get(position));
        holder.tv_name.setText(user_name.get(position));
        holder.tv_qual.setText(user_tagline.get(position));
        holder.tv_top.setText(topic_name.get(position));

        holder.iview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","Inside onCLick");

                recyclerView.setVisibility(View.GONE);
//                manager.beginTransaction().replace(R.id.hs_rel,new home2_screen()).commit();
                home2_screen fragment = new home2_screen();
                Bundle bundle = new Bundle();
                bundle.putString("NAME",user_name.get(position));
                bundle.putString("TAGLINE",user_tagline.get(position));
                bundle.putString("QUESTION",ques_list.get(position));
                bundle.putString("TOPIC",topic_name.get(position));
                fragment.setArguments(bundle);

                holder.mCommunication.respond(user_name.get(position),user_tagline.get(position),ques_list.get(position),topic_name.get(position));


            }
        });
    }

    @Override
    public int getItemCount() {
        return ques_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView tv_ques,tv_name,tv_qual,tv_top;
        ImageView iview;
        RoundedImageView imageView;
        RelativeLayout relativeLayout;
        FragmentCommunication mCommunication;
        public ViewHolder(View itemView) {
            super(itemView);

            tv_ques = (TextView) itemView.findViewById(R.id.ques);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_qual = (TextView) itemView.findViewById(R.id.tv_qual);
            imageView = (RoundedImageView) itemView.findViewById(R.id.logo_in_homescreen);
            tv_top = (TextView) itemView.findViewById(R.id.ques_title);
            iview = (ImageView) itemView.findViewById(R.id.btn_answers);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel_main);
            mCommunication = communication;



        }
    }


//    private void getQues(){
//
//        final Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
//        get_detailed_fromQuesAPI fromQues = retrofit.create(get_detailed_fromQuesAPI.class);
//
//        Call<List<get_detailed_fromQues>> call = fromQues.getQues();
//
//        call.enqueue(new Callback<List<get_detailed_fromQues>>() {
//            @Override
//            public void onResponse(Call<List<get_detailed_fromQues>> call, Response<List<get_detailed_fromQues>> response) {
//                    if(response.isSuccessful()){
//
//                        Log.d(TAG,"Inside onResponse");
//                        list = response.body();
//                        int i=0;
//                        while(i<list.size()){
//                            ques_list.add(list.get(i).getQues_text());
//                            Log.d(TAG,"Ques is :"+list.get(i).getQues_text());
//                            user_id.add(list.get(i).getUser_id());
//                            i++;
//                        }
//
//                    }
//                    else{
//                        Log.d(TAG,"Inside onResponse else");
//                    }
//            }
//
//            @Override
//            public void onFailure(Call<List<get_detailed_fromQues>> call, Throwable t) {
//
//                Log.d(TAG,"Inside onFailure");
//                t.printStackTrace();
//            }
//        });
//
//    }
//
//    private void get_user_info(){
//
//        int i=0,uid=-1;
//
//
//        while (i<user_id.size()){
//
//            uid = user_id.get(i);
//            final Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
//            get_user_info info = retrofit.create(get_user_info.class);
//
//            Call<List<User_Info>> call = info.get_user_info(uid);
//
//            final int finalI = i;
//            call.enqueue(new Callback<List<User_Info>>() {
//                @Override
//                public void onResponse(Call<List<User_Info>> call, Response<List<User_Info>> response) {
//                    if(response.isSuccessful()) {
//                        Log.d(TAG,"Inside getting user info");
//                        List<User_Info> uinfo = response.body();
//                        User_Info userInfo = uinfo.get(0);
//                        user_name.add(userInfo.getName());
//                        Log.d(TAG,"User Name"+user_name.get(finalI));
//                        user_tagline.add(userInfo.getTagLine());
//                        user_image.add(userInfo.getImageURL());
//                    }
//                    else{
//                        Log.d(TAG,"The User does not exists");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<User_Info>> call, Throwable t) {
//
//                    Log.d(TAG,"Inside user onFailure");
//                }
//            });
//            i++;
//        }
//    }

}
