package com.example.fireteranotification.model;

public class AppModel {
    String AppName;
    int Image;

    public AppModel(String appName, int image) {
        AppName = appName;
        Image = image;
    }

    public String getAppName() {
        return AppName;
    }

    public int getImage() {
        return Image;
    }
}
