package com.login_signup_screendesign_demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shantanu on 19/9/17.
 */

public class User_Info implements Serializable {

    @SerializedName("Email_ID")
    @Expose
    private  String email_id;

    @SerializedName("Name")
    @Expose
    private  String name;

    @SerializedName("Password")
    @Expose
    private  String password;

    @SerializedName("Address")
    @Expose
    private  String address;

    @SerializedName("Mobile_No")
    @Expose
    private  String mob;

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

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }
}
