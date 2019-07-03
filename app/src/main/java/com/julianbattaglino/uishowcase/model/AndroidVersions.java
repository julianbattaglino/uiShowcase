package com.julianbattaglino.uishowcase.model;

/**
 * Created by Julian Battaglino.
 */
public class AndroidVersions {
    String title, image, api;

    public AndroidVersions(String title, String image, String api) {
        this.title = title;
        this.image = image;
        this.api = api;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
