package com.example.fragments.Adapters;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fragments.Fragments.CallsFragment;
import com.example.fragments.Fragments.ChatsFragment;
import com.example.fragments.Fragments.StatusFragment;


public class VpAdapter extends FragmentPagerAdapter {

    public VpAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
             return new ChatsFragment();
        } else if (position==1) {
            return new StatusFragment();
        }else {
            return new CallsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "chats";
        } else if (position==1) {
            return "status";
        }else{
            return "calls";
        }
    }
}
