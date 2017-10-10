package com.login_signup_screendesign_demo;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by shantanu on 7/10/17.
 */

public interface UploadImageInterface {

    @Multipart
    @POST("index.php")
    public Call<UploadObject> uploadFile(@Part MultipartBody.Part file, @Part("name") RequestBody name);
}
