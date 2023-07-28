package com.example.fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragments.DatabaseModels.DbHelper;
import com.example.fragments.DatabaseModels.Users;
import com.example.fragments.DatabaseModels.UsersDao;
import com.example.fragments.DatabaseModels.UsersDes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class SelectProfileActivity extends AppCompatActivity {
CircleImageView circleImageViewSelectProfile;
FloatingActionButton fabOpenGallery;
public static EditText selectName;
    public static EditText selectDes;
Button nextBtn;
int id;
public static final int GALLARY_REQ_CODE= 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);
        circleImageViewSelectProfile=findViewById(R.id.circleImageViewSelectProfile);
        fabOpenGallery=findViewById(R.id.fabOpenGallery);
        selectName=findViewById(R.id.etSelectName);
        selectDes=findViewById(R.id.etSelectDes);
        nextBtn=findViewById(R.id.nextBtn);
        onClick();

        SharedPreferences preferences=getSharedPreferences("ayush",MODE_PRIVATE);
        String name=preferences.getString("name",null);
        String des=preferences.getString("des",null);
        if(name!=null && des!=null){
            Intent intent=new Intent(SelectProfileActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void onClick() {
        fabOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGallery();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddDatabase();
            }
        });
    }

    private void AddDatabase() {
        DbHelper dbHelper= Room.databaseBuilder(getApplicationContext(),DbHelper.class,"user")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        UsersDao usersDao=dbHelper.usersDao();
        usersDao.insert(new Users(id,selectName.getText().toString()));
        usersDao.insert(new UsersDes(id,selectDes.getText().toString()));


        SharedPreferences preferences=getSharedPreferences("ayush",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("name",selectName.getText().toString());
        editor.putString("des",selectDes.getText().toString());

//                    editor.putBoolean("logged",true);
        editor.apply();

        Intent intent=new Intent(SelectProfileActivity.this,MainActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("name",selectName.getText().toString());
        intent.putExtra("des",selectDes.getText().toString());
        startActivity(intent);
    }

    private void openGallery() {

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,GALLARY_REQ_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GALLARY_REQ_CODE){
            circleImageViewSelectProfile.setImageURI(data.getData());

            Toast.makeText(this, " profile Selected", Toast.LENGTH_SHORT).show();
        }
    }
}