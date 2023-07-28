package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.fragments.Adapters.ChatsAdapter;
import com.example.fragments.Adapters.VpAdapter;
import com.example.fragments.Models.ChatsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    FloatingActionButton myFab;
     private static final int CAMERA_REQ_CODE=1;
     List<ChatsModel>chatsModels=new ArrayList<>();
     ChatsAdapter chatsAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.toolbar);
        myFab = findViewById(R.id.myFab);

//        getSupportActionBar().hide();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#008069"));

        tabLayout.setupWithViewPager(viewPager);

        VpAdapter adapter = new VpAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        chatsModels=ChatsModel.getData();
        chatsAdapter=new ChatsAdapter(this,chatsModels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.whatsapp_menu,menu);
        MenuItem searchViewItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Search here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void filterList(String text) {

        List<ChatsModel>filteredList=new ArrayList<>();
        for(ChatsModel chatsModel: chatsModels){
            if(chatsModel.getName().toLowerCase().contains(text.toLowerCase())||
                    chatsModel.getLastMsg().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(chatsModel);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else {
            chatsAdapter.setFilteredList(filteredList);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.camera:
                openCamara();
                break;

            case R.id.newBroadcast:
                Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();

                break;
            case R.id.linkedDevices:
                Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.starredMsg:
                Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payments:
                Toast.makeText(this, "Not Available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Intent intent=new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openCamara() {
        Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(iCamera,CAMERA_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK){
            if(requestCode==CAMERA_REQ_CODE){
                Bitmap img=(Bitmap)(data.getExtras().get("data"));


            }
        }
    }
}


