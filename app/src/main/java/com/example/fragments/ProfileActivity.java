package com.example.fragments;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    CircleImageView profileOfProfile;
    TextView profileNameTv;
    static TextView profileDiscriptionTv;
    TextView profileMediaTv;
    TextView createProfileGroupTv;
    TextView profileGroupTv;
    TextView commonProfileGroupTv;
    TextView blockProfileTv;
    TextView reportProfileTv;
    ImageView callButtonProfileIv, videoCallButtonProfileIv, searchButtonProfileIv, createGroupIv, commonGroupIv, blockIv, reportIv, image1, image2, image3, image4, image5, image6, image7, image8;
    LinearLayout ReportLinearLayout, BlockLinearLayout;
    String name;
    int profileImage = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ECEAEA"));

        findIdAll();
        onClick();


        name = getIntent().getStringExtra("profileName");
        profileNameTv.setText(name);
        createProfileGroupTv.setText("Create group With" + " " + name);
        reportProfileTv.setText("Report" + " " + name);
        blockProfileTv.setText("Block" + " " + name);

        if (getIntent().hasExtra("profileImage")) {
            profileImage = getIntent().getIntExtra("profileImage", 0);
        }
        profileOfProfile.setImageResource(profileImage);

    }

    private void findIdAll() {

        profileOfProfile = findViewById(R.id.profileOfProfile);
        profileNameTv = findViewById(R.id.profileNameTv);
        profileDiscriptionTv = findViewById(R.id.profileDiscriptionTv);
        profileMediaTv = findViewById(R.id.profileMediaTv);
        createProfileGroupTv = findViewById(R.id.createProfileGroupTv);
        profileGroupTv = findViewById(R.id.profileGroupTv);
        commonProfileGroupTv = findViewById(R.id.commonProfileGroupTv);
        blockProfileTv = findViewById(R.id.blockProfileTv);
        reportProfileTv = findViewById(R.id.reportProfileTv);
        callButtonProfileIv = findViewById(R.id.callButtonProfileIv);
        videoCallButtonProfileIv = findViewById(R.id.videoCallButtonProfileIv);
        searchButtonProfileIv = findViewById(R.id.searchButtonProfileIv);
        createGroupIv = findViewById(R.id.createGroupIv);
        commonGroupIv = findViewById(R.id.commonGroupIv);
        blockIv = findViewById(R.id.blockIv);
        reportIv = findViewById(R.id.reportIv);
        ReportLinearLayout = findViewById(R.id.ReportLinearLayout);
        BlockLinearLayout = findViewById(R.id.blockLinearLayout);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
    }

    private void onClick() {
        callButtonProfileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Calling......", Toast.LENGTH_SHORT).show();
            }
        });
        videoCallButtonProfileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Video Calling......", Toast.LENGTH_SHORT).show();
            }
        });
        searchButtonProfileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "search here......", Toast.LENGTH_SHORT).show();
            }
        });
        BlockLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle(" Alert !");
                builder.setMessage("do you want to block" + " " + name + "?");
                builder.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ProfileActivity.this, "Blocked" + " " + name, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(true);
                builder.show();
                builder.create();
            }
        });
        ReportLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle(" Alert !");
                builder.setMessage("do you want to Report" + " " + name + "?");
                builder.setPositiveButton("Report", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ProfileActivity.this, "Reported" + " " + name, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(true);
                builder.show();
                builder.create();
            }
        });

    }
}