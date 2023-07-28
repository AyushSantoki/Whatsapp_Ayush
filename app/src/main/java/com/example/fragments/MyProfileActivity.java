package com.example.fragments;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragments.DatabaseModels.DbHelper;
import com.example.fragments.DatabaseModels.Users;
import com.example.fragments.DatabaseModels.UsersDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {
    ImageView backBtnMyProfilesIv, submitNameBtn, submitDesBtn;
    CircleImageView circleImageViewMyProfile;
    LinearLayout linearLayoutNameProfile, linearLayoutDesProfile;
    public static TextView nameMyProfileTv, desMyProfileTv;
    FloatingActionButton fabOpenGallery;
    int id;

    SharedPreferences preferences;
    public static final String SHARD_PREF_NAME = "mypref";
    public static final String KEY_NAME = "name";
    public static final String KEY_DES = "des";
    public static final int GALLARY_REQ_CODE = 1;

    String nameData;
    String desData;
    DbHelper dbHelper;
    UsersDao usersDao;
    EditText edtTextDes;
    EditText edtTextName;

    List<Users> userLists;
    int position ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        findAll();
        onClick();

         dbHelper = Room.databaseBuilder(getApplicationContext(), DbHelper.class, "user")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
         usersDao = dbHelper.usersDao();

        nameData = usersDao.fetchNameData();
        nameMyProfileTv.setText(nameData);

        desData= usersDao.fetchDesData();
        desMyProfileTv.setText(desData);


    }

    private void onClick() {
        backBtnMyProfilesIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        linearLayoutNameProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MyProfileActivity.this);
                builder.setTitle("Enter your name");
                View view1 = getLayoutInflater().inflate(R.layout.alert_dialog_name, null);
                edtTextName = view1.findViewById(R.id.edtTextName);


                builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        updateData(edtTextName.getText().toString());

                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setView(view1);
                builder.create();
                builder.setCancelable(true);
                builder.show();
            }
        });
        linearLayoutDesProfile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyProfileActivity.this);
                builder.setTitle("Add About");
                View view1 = getLayoutInflater().inflate(R.layout.alert_dialog_des, null);
//                EditText edtTextDes;
                edtTextDes = view1.findViewById(R.id.edtTextDes);

                builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setView(view1);
                builder.create();
                builder.setCancelable(true);
                builder.show();
            }
        });
        fabOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    private void findAll() {
        backBtnMyProfilesIv = findViewById(R.id.backBtnMyProfilesIv);
        circleImageViewMyProfile = findViewById(R.id.circleImageViewMyProfile);
        submitNameBtn = findViewById(R.id.submitNameBtn);
        submitDesBtn = findViewById(R.id.submitDesBtn);
        nameMyProfileTv = findViewById(R.id.nameMyProfileTv);
        desMyProfileTv = findViewById(R.id.desMyProfileTv);
        fabOpenGallery = findViewById(R.id.fabOpenGallery);
        linearLayoutNameProfile = findViewById(R.id.linearLayoutNameProfile);
        linearLayoutDesProfile = findViewById(R.id.linearLayoutDesProfile);
    }


    private void updateData(String name) {
        //update data
        dbHelper = Room.databaseBuilder(getApplicationContext(), DbHelper.class, "user")
                .allowMainThreadQueries()
                .build();
        usersDao = dbHelper.usersDao();
        usersDao.updatename(name,id);
    }
    private void openGallery() {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLARY_REQ_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == GALLARY_REQ_CODE && data.getData() != null) {

            circleImageViewMyProfile.setImageURI(data.getData());

            Toast.makeText(this, " profile changed", Toast.LENGTH_SHORT).show();
        }
    }

}