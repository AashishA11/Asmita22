package com.example.asmita22.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asmita22.Models.TeamModel;
import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class teamAdaptor extends RecyclerView.Adapter<teamAdaptor.viewholder> {

    ArrayList<TeamModel>list;
    Context context;

    public teamAdaptor(ArrayList<TeamModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public teamAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_sample,parent,false);
        return new viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull teamAdaptor.viewholder holder, int position) {

        final TeamModel model= list.get(position);
        holder.name.setText(model.getName());
        holder.position.setText(model.getPosition());
//        Glide.with(context).load("http://goo.gl/gEgYUd").into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        CircularImageView img,mail;
        TextView name,position;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.team_img);
            name=itemView.findViewById(R.id.team_name);
            position=itemView.findViewById(R.id.team_position);
            mail=itemView.findViewById(R.id.team_mail);
        }
    }
}
