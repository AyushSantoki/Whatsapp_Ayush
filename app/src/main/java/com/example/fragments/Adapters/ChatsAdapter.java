package com.example.fragments.Adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.ChatsActivity;
import com.example.fragments.Models.ChatsModel;
import com.example.fragments.ProfileActivity;
import com.example.fragments.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.viewHolder> {
    Context context;
    List<ChatsModel>chatsModels;
    ImageView dialogImage;

    public ChatsAdapter(Context context, List<ChatsModel> chatsModels) {
        this.context = context;
        this.chatsModels = chatsModels;
    }
    public void setFilteredList(List<ChatsModel>filteredList){
        this.chatsModels=filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ChatsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chats_recycleview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {
        ChatsModel model=chatsModels.get(position);
        holder.profile.setImageResource((model.getImage()));
        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.dialog_item);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(true);
                ImageView callButtonDialogImg=dialog.findViewById(R.id.callButtonDialogImg);
                ImageView videoCallButtonDialogImg=dialog.findViewById(R.id.videoCallButtonDialogImg);
                ImageView iButtonDialogImg=dialog.findViewById(R.id.iButtonDialogImg);
                dialogImage=dialog.findViewById(R.id.dialogImage);
                dialogImage.setImageResource(model.getImage());
                callButtonDialogImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "calling.......", Toast.LENGTH_SHORT).show();
                    }
                });

                videoCallButtonDialogImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "video calling.......", Toast.LENGTH_SHORT).show();
                    }
                });

                iButtonDialogImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ProfileActivity.class);
                        intent.putExtra("profileImage",model.getImage());
                        intent.putExtra("profileName",model.getName());
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.name.setText(model.getName());
        holder.lastMsg.setText(model.getLastMsg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ChatsActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getName());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return chatsModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name ,lastMsg;
        ImageView profile;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.profile);
            name=itemView.findViewById(R.id.name);
            lastMsg=itemView.findViewById(R.id.lastMsg);
        }
    }
}
