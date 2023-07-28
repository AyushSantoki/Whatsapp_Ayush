package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragments.Models.ChatsModel;

import java.util.ArrayList;
import java.util.List;

public class ChatsActivity extends AppCompatActivity {
    EditText typeChat;
    TextView yourName;
    ImageView backBtn, yourProfile, others, contectCall, videoCall;
    LinearLayout clickForProfile;
    List<ChatsModel> chatsModels = new ArrayList<>();
    int profileImg;
    String name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        clickForProfile = findViewById(R.id.clickForProfile);
        typeChat = findViewById(R.id.typeChat);
        backBtn = findViewById(R.id.backBtn);
        yourProfile = findViewById(R.id.yourProfile);
        yourName = findViewById(R.id.yourName);
        others = findViewById(R.id.others);
        contectCall = findViewById(R.id.contectCall);
        videoCall = findViewById(R.id.videoCall);

        clickWork();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            profileImg = bundle.getInt("image");
            name = bundle.getString("name");
            yourProfile.setImageResource(profileImg);
            yourName.setText(name);
        }
    }

    private void clickWork() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        contectCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatsActivity.this, "calling.......", Toast.LENGTH_SHORT).show();
            }
        });
        videoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatsActivity.this, "video calling.......", Toast.LENGTH_SHORT).show();
            }
        });
        clickForProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourProfile.setDrawingCacheEnabled(true);
                Intent intent = new Intent();
                intent.putExtra("profileName", name);
                intent.putExtra("profileImage", profileImg);
                intent.setClass(ChatsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}