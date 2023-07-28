package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragments.DatabaseModels.DbHelper;
import com.example.fragments.DatabaseModels.Users;
import com.example.fragments.DatabaseModels.UsersDao;
import com.example.fragments.DatabaseModels.UsersDes;

public class SettingActivity extends AppCompatActivity {
    LinearLayout linearLayoutSettings,linearLayoutSettingsAccount,linearLayoutSettingsPrivacy,linearLayoutSettingsNotifications,linearLayoutSettingsStorageData,linearLayoutSettingsChat,
            linearLayoutSettingsAppLanguage,linearLayoutSettingsHelp,linearLayoutSettingsAvatar,linearLayoutSettingsInviteFrds;

    ImageView profileSettingsIv,backBtnSettingsIv;
   public TextView nameSettingsTv,decSettingsTv;

   String name,des;

    SharedPreferences preferences;

    public static final String SHARD_PREF_NAME="mypref";
    public static final String KEY_NAME="name";
    public static final String KEY_DES="des";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findAll();
        onClick();

        DbHelper dbHelper= Room.databaseBuilder(getApplicationContext(),DbHelper.class,"user")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        UsersDao usersDao=dbHelper.usersDao();

        String nameData=usersDao.fetchNameData();
        nameSettingsTv.setText(nameData);

        String desData= usersDao.fetchDesData();
        decSettingsTv.setText(desData);

//        SharedPreferences preferences=getSharedPreferences("ayush",MODE_PRIVATE);
//        name=preferences.getString("name",null);
//        des=preferences.getString("des",null);
//        if(name!=null||des!=null){
//            nameSettingsTv.setText(name);
//            decSettingsTv.setText(des);
//        }

        }


    private void findAll() {
        linearLayoutSettings=findViewById(R.id.linearLayoutSettings);
        linearLayoutSettingsAccount=findViewById(R.id.linearLayoutSettingsAccount);
        linearLayoutSettingsPrivacy=findViewById(R.id.linearLayoutSettingsPrivacy);
        linearLayoutSettingsNotifications=findViewById(R.id.linearLayoutSettingsNotifications);
        linearLayoutSettingsStorageData=findViewById(R.id.linearLayoutSettingsStorageData);
        linearLayoutSettingsAppLanguage=findViewById(R.id.linearLayoutSettingsAppLanguage);
        linearLayoutSettingsHelp=findViewById(R.id.linearLayoutSettingsHelp);
        linearLayoutSettingsAvatar=findViewById(R.id.linearLayoutSettingsAvatar);
        linearLayoutSettingsInviteFrds=findViewById(R.id.linearLayoutSettingsInviteFrds);
        profileSettingsIv=findViewById(R.id.profileSettingsIv);
        backBtnSettingsIv=findViewById(R.id.backBtnSettingsIv);
        nameSettingsTv=findViewById(R.id.nameSettingsTv);
        decSettingsTv=findViewById(R.id.decSettingsTv);
        linearLayoutSettingsChat=findViewById(R.id.linearLayoutSettingsChats);
    }
    private void onClick() {
        backBtnSettingsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        linearLayoutSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences=getSharedPreferences("ayush",MODE_PRIVATE);
                 name=preferences.getString("name",null);
                 des=preferences.getString("des",null);

                Intent intent=new Intent(SettingActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutSettingsStorageData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsAppLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsInviteFrds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSettingsAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingActivity.this, "not available", Toast.LENGTH_SHORT).show();
            }
        });

    }

}