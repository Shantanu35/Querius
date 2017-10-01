package com.login_signup_screendesign_demo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by shantanu on 30/9/17.
 */

public interface getTopicID {

    @POST("db_getTopic_id.php")
    public Call<ArrayList<topicID>> getTopic_id();

}
