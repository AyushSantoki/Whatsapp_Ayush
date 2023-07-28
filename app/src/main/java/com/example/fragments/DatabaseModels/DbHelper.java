package com.example.fragments.DatabaseModels;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class,UsersDes.class},version = 1)
public abstract class DbHelper extends RoomDatabase {
 public abstract UsersDao usersDao();
}

