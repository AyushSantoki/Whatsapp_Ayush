package com.example.fragments.Models;

import com.example.fragments.R;

import java.util.ArrayList;
import java.util.List;

public class ChatsModel {
    int image;
    String name,lastMsg;

    public ChatsModel(int image, String name, String lastMsg) {
        this.image = image;
        this.name = name;
        this.lastMsg = lastMsg;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public static List<ChatsModel> getData()
    {
        List<ChatsModel> list = new ArrayList<>();
        list.add(new ChatsModel(R.drawable.profile_img,"ayush","hii"));
        list.add(new ChatsModel(R.drawable.user,"dhrumil","yoo"));
        list.add(new ChatsModel(R.drawable.profile_img,"dhruv","hello"));
        list.add(new ChatsModel(R.drawable.user,"samruddhi","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "kishan","hello"));
        list.add(new ChatsModel(R.drawable.user, "rahul","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "neel","hello"));
        list.add(new ChatsModel(R.drawable.user, "anish","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "krushal","hello"));
        list.add(new ChatsModel(R.drawable.user, "patel","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "priya","hello"));
        list.add(new ChatsModel(R.drawable.user, "prakshi","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "rohan","hello"));
        list.add(new ChatsModel(R.drawable.user, "jeel","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "harsh","hello"));
        list.add(new ChatsModel(R.drawable.user, "janki","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "keyur","hello"));
        list.add(new ChatsModel(R.drawable.user, "rajni","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "krushal","hello"));
        list.add(new ChatsModel(R.drawable.user, "bhargav","hello"));
        list.add(new ChatsModel(R.drawable.profile_img, "devang","hello"));

        return list;
    }
}
