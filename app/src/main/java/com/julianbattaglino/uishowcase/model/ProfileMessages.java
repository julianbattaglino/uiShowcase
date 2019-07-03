package com.julianbattaglino.uishowcase.model;

/**
 * Created by Julian Battaglino.
 */
public class ProfileMessages {
    String time_ago, from, app_name;
    int image;

    public ProfileMessages(String time_ago, String from, String app_name, int image) {
        this.time_ago = time_ago;
        this.from = from;
        this.app_name = app_name;
        this.image = image;
    }

    public String getTime_ago() {
        return time_ago;
    }

    public void setTime_ago(String time_ago) {
        this.time_ago = time_ago;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
