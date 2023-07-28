package com.example.fragments.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.Adapters.ChatsAdapter;
import com.example.fragments.Models.ChatsModel;
import com.example.fragments.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {
    RecyclerView recyclerView;
    ChatsAdapter adapter;

    FloatingActionButton myFabChats;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats_, container, false);
        recyclerView=view.findViewById(R.id.recycleView);
        myFabChats=view.findViewById(R.id.myFabChat);

        List<ChatsModel>chatsModels=new ArrayList<>();

        if(chatsModels.isEmpty()) {
            chatsModels = ChatsModel.getData();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new ChatsAdapter(getActivity(),chatsModels);
        recyclerView.setAdapter(adapter);


        return view;
    }


}