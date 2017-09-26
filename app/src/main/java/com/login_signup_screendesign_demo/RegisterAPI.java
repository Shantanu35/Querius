package com.login_signup_screendesign_demo;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shantanu on 19/9/17.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("db_insert.php")
    public Call<Integer> insertUser(
           @Field("Name") String name,
           @Field("Email_ID") String email,
           @Field("Address") String addr,
           @Field("Mobile_No") String mob,
           @Field("Password") String passwd);//           Callback<retrofit2.Response> callback);
}
