package com.example.fragments.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fragments.Adapters.CallAdapter;
import com.example.fragments.CreateLinkActivity;
import com.example.fragments.Models.CallsModel;
import com.example.fragments.R;

import java.util.ArrayList;
import java.util.List;


public class CallsFragment extends Fragment {
    RecyclerView rvCalls;
    CallAdapter adapter;
    LinearLayout linearLayoutCalls;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calls_, container, false);

        linearLayoutCalls=view.findViewById(R.id.linearLayoutCalls);
        onClick();
        rvCalls=view.findViewById(R.id.rvCalls);
        List<CallsModel> callsModels=new ArrayList<>();
        callsModels=getData();
        rvCalls.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new CallAdapter(getActivity(),callsModels);
        rvCalls.setAdapter(adapter);
        return view;
    }
    private List<CallsModel> getData()
    {
        List<CallsModel> list = new ArrayList<>();
        list.add(new CallsModel(R.drawable.profile_img,R.drawable.call_img,"ayush","yesterday"));
        list.add(new CallsModel(R.drawable.user,R.drawable.video_img,"rahul","yesterday"));
        list.add(new CallsModel(R.drawable.profile_img,R.drawable.call_img,"dhruv","yesterday"));
        list.add(new CallsModel(R.drawable.user,R.drawable.video_img,"neel","yesterday"));
        list.add(new CallsModel(R.drawable.profile_img,R.drawable.call_img,"harsh","yesterday"));
        list.add(new CallsModel(R.drawable.user,R.drawable.video_img,"kishan","yesterday"));
        list.add(new CallsModel(R.drawable.profile_img,R.drawable.call_img,"krushal","yesterday"));
        list.add(new CallsModel(R.drawable.user,R.drawable.video_img,"rohan","yesterday"));
        list.add(new CallsModel(R.drawable.profile_img,R.drawable.call_img,"patel","yesterday"));
        list.add(new CallsModel(R.drawable.user,R.drawable.video_img,"priya","yesterday"));
        return list;
    }
    private void onClick() {
        linearLayoutCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CreateLinkActivity.class);
                startActivity(intent);
            }
        });
    }

}