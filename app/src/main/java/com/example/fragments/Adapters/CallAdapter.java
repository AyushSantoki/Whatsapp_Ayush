package com.example.fragments.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Call_InfoActivity;
import com.example.fragments.ChatsActivity;
import com.example.fragments.Models.CallsModel;
import com.example.fragments.Models.ChatsModel;
import com.example.fragments.ProfileActivity;
import com.example.fragments.R;

import java.util.List;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.viewHolder> {
    Context context;
    List<CallsModel> callsModels;
    ImageView dialogImage;

    public CallAdapter(Context context, List<CallsModel> callsModels) {
        this.context = context;
        this.callsModels = callsModels;
    }

    @NonNull
    @Override
    public CallAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.calls_recycleview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallAdapter.viewHolder holder, int position) {
        CallsModel model=callsModels.get(position);
        holder.profileCAll.setImageResource(model.getImg());
        holder.profileCAll.setOnClickListener(new View.OnClickListener() {
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
                dialogImage.setImageResource(model.getImg());
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
                        intent.putExtra("profileImage",model.getImg());
                        intent.putExtra("profileName",model.getName());
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.imgCall.setImageResource(model.getImgCall());
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "calling.....", Toast.LENGTH_SHORT).show();
            }
        });
        holder.callLink.setText(model.getCallLink());
        holder.nameCall.setText(model.getName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                        Intent intent=new Intent(context, Call_InfoActivity.class);
//                        intent.putExtra("image",model.getImg());
//                        intent.putExtra("name",model.getName());
//                        context.startActivity(intent);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return callsModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView profileCAll,imgCall;
        TextView nameCall,callLink;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profileCAll=itemView.findViewById(R.id.profileCAll);
            imgCall=itemView.findViewById(R.id.imgCall);
            nameCall=itemView.findViewById(R.id.nameCall);
            callLink=itemView.findViewById(R.id.callLink);
        }
    }
}
