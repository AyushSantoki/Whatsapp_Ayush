package com.example.fragments.Models;

public class CallsModel {
    int img,imgCall;
    String name,callLink;

    public CallsModel(int img, int imgCall, String name, String callLink) {
        this.img = img;
        this.imgCall = imgCall;
        this.name = name;
        this.callLink = callLink;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImgCall() {
        return imgCall;
    }

    public void setImgCall(int imgCall) {
        this.imgCall = imgCall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallLink() {
        return callLink;
    }

    public void setCallLink(String callLink) {
        this.callLink = callLink;
    }
}
