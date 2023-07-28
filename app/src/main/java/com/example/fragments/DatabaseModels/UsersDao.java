package com.example.fragments.DatabaseModels;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UsersDao {

    @Insert
    void insert(Users users);

    @Insert
    void insert(UsersDes usersDes);

    @Update
    void Update(Users users);

    @Query("update users set name=:name where id=:fid")
    void updatename(String name,int fid);

    @Query("update usersdes set des=:des where id=:fid")
    void updatedes(String des,int fid);

//    @Query("select id , name from users where id=:uid")
//    void findByUserId(String uid);

//    @Query("select id , name from users ")
//    void fetch();

    @Query("SELECT name FROM Users ")
    String fetchNameData();

    @Query("select des from UsersDes ")
    String fetchDesData();
}
