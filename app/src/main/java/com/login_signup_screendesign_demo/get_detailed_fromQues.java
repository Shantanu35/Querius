package com.login_signup_screendesign_demo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shantanu on 1/10/17.
 */

public class get_detailed_fromQues {

    @SerializedName("qtext")
    private String ques_text;

    @SerializedName("userid")
    private int user_id;

    @SerializedName("qtopic_id")
    private int topic_id;

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getQues_text() {
        return ques_text;
    }

    public void setQues_text(String ques_text) {
        this.ques_text = ques_text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
