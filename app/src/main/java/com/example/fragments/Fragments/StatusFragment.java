package com.example.fragments.Fragments;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fragments.Adapters.StatusAdapter;
import com.example.fragments.Models.StatusModel;
import com.example.fragments.R;

import java.util.ArrayList;
import java.util.List;


public class StatusFragment extends Fragment {
    RecyclerView rvStatus;
    LinearLayout linearLayoutStatus;
    StatusAdapter adapter;
    private static final int CAMERA_REQ_CODE=1;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_status_, container, false);

        linearLayoutStatus=view.findViewById(R.id.linearLayoutStatus);
        onClick();
        rvStatus=view.findViewById(R.id.rvStatus);
        List<StatusModel> statusModels=new ArrayList<>();
        statusModels=getData();
        rvStatus.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new StatusAdapter(getActivity(),statusModels);
        rvStatus.setAdapter(adapter);
        return view;
    }
    private List<StatusModel> getData()
    {
        List<StatusModel> list = new ArrayList<>();
        list.add(new StatusModel(R.drawable.profile_img,"ayush","hii"));
        list.add(new StatusModel(R.drawable.user,"dhrumil","yoo"));
        list.add(new StatusModel(R.drawable.profile_img,"priya","yoo"));
        list.add(new StatusModel(R.drawable.user,"anish","hii"));
        list.add(new StatusModel(R.drawable.profile_img,"rahul","yoo"));
        list.add(new StatusModel(R.drawable.user,"kishan","hii"));
        list.add(new StatusModel(R.drawable.profile_img,"dhruv","yoo"));
        list.add(new StatusModel(R.drawable.user,"ramesh","hii"));
        list.add(new StatusModel(R.drawable.profile_img,"neel","yoo"));
        return list;
    }
    private void onClick() {
        linearLayoutStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(iCamera,CAMERA_REQ_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==RESULT_OK){
            if(requestCode==CAMERA_REQ_CODE){
                Bitmap img=(Bitmap)(data.getExtras().get("data"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}