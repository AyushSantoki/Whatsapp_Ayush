package com.example.fragments.Models;

public class StatusModel {
    int img;
    String name,time;

    public StatusModel(int img, String name, String time) {
        this.img = img;
        this.name = name;
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
