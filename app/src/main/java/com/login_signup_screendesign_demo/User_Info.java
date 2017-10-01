package com.login_signup_screendesign_demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shantanu on 19/9/17.
 */

public class User_Info implements Serializable {

    @SerializedName("userid")
    @Expose
    private int user_id;

    @SerializedName("imageurl")
    @Expose
    private String imageURL;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @SerializedName("email")
    @Expose
    private  String email_id;

    @SerializedName("User_name")
    @Expose
    private  String name;

    @SerializedName("password")
    @Expose
    private  String password;

    @SerializedName("location")
    @Expose
    private  String address;

    @SerializedName("tagline")
    @Expose
    private  String tagLine;

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }
}
