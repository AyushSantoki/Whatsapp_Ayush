package com.example.fragments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Models.StatusModel;
import com.example.fragments.R;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.viewHolder> {
    Context context;
    List<StatusModel> statusModels;


    public StatusAdapter(Context context, List<StatusModel> statusModels) {
        this.context = context;
        this.statusModels = statusModels;
    }
    @NonNull
    @Override
    public StatusAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.status_recycleview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusAdapter.viewHolder holder, int position) {
        StatusModel model=statusModels.get(position);
        holder.profile1.setImageResource((model.getImg()));
        holder.name1.setText(model.getName());
        holder.time.setText(model.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, model.getName() + " "+"didn't add any status", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name1,time;
        ImageView profile1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile1=itemView.findViewById(R.id.profile1);
            name1=itemView.findViewById(R.id.name1);
            time=itemView.findViewById(R.id.time);
        }
    }
}
