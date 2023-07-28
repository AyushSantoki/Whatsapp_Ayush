package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateLinkActivity extends AppCompatActivity {
    ImageView backBtnCallLinkIv,sendCallLinkIv,shareLinkIv,copyLinkIv;
    LinearLayout linearLayoutCAllLink,linearLayoutCallType,linearLayoutSendLink,linearLayoutCopyLink,linearLayoutShareLink;

    FloatingActionButton fabCallLink;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_link);
        backBtnCallLinkIv=findViewById(R.id.backBtnCallLinkIv);
        sendCallLinkIv=findViewById(R.id.sendCallLinkIv);
        shareLinkIv=findViewById(R.id.shareLinkIv);
        copyLinkIv=findViewById(R.id.copyLinkIv);
        linearLayoutCAllLink=findViewById(R.id.linearLayoutCAllLink);
        linearLayoutCallType=findViewById(R.id.linearLayoutCallType);
        linearLayoutSendLink=findViewById(R.id.linearLayoutSendLink);
        linearLayoutCopyLink=findViewById(R.id.linearLayoutCopyLink);
        linearLayoutShareLink=findViewById(R.id.linearLayoutShareLink);
        fabCallLink=findViewById(R.id.fabCallLink);
        onClick();
    }
    private void onClick(){
        linearLayoutCAllLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateLinkActivity.this, "Link Generated", Toast.LENGTH_SHORT).show();
            }
        });
        fabCallLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateLinkActivity.this, "Link Generated", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutCallType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateLinkActivity.this, "Selected Video", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutCopyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateLinkActivity.this, "Copy Link", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutSendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateLinkActivity.this, "Send To WhatsApp", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutShareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://call.whatsapp.com/video/fuqdy1waicjBQvthZQeSmp"));
                startActivity(intent);
            }
        });
        backBtnCallLinkIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}