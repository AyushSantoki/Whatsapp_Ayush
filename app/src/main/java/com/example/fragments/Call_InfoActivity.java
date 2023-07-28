package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Call_InfoActivity extends AppCompatActivity {
ImageView profileCallInfo,backBtnCallInfoIv;
TextView nameCallInfo;
ImageView dialogImage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_info);
        profileCallInfo=findViewById(R.id.profileCallInfo);
        backBtnCallInfoIv=findViewById(R.id.backBtnCallInfoIv);
        nameCallInfo=findViewById(R.id.nameCallInfo);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            int profileImg=bundle.getInt("image");
            String name=bundle.getString("name");
            profileCallInfo.setImageResource(profileImg);
            nameCallInfo.setText(name);
            backBtnCallInfoIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }
}