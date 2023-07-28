package com.example.fragments.DatabaseModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UsersDes {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "des")
    String des;

    public UsersDes(int id, String des) {
        this.id = id;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
