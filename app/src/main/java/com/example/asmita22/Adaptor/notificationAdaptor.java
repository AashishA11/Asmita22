package com.example.asmita22.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asmita22.Models.NotificationModel;
import com.example.asmita22.Models.TeamModel;
import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class notificationAdaptor extends RecyclerView.Adapter<notificationAdaptor.viewholder> {

    ArrayList<NotificationModel>list;
    Context context;
    FirebaseDatabase firebaseDatabase;
    public notificationAdaptor(ArrayList<NotificationModel> list, Context context) {
        this.list = list;
        this.context = context;
        firebaseDatabase=FirebaseDatabase.getInstance();
    }
    @NonNull
    @Override
    public notificationAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.notification_layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        NotificationModel model=list.get(position);
        holder.Event.setText(model.getEvent());
        holder.Info.setText(model.getInfo());
        holder.Date.setText(model.getDate());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        TextView Event,Date,Info;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Event=itemView.findViewById(R.id.noti_event_name);
            Date=itemView.findViewById(R.id.noti_date);
            Info=itemView.findViewById(R.id.noti_info);
        }
    }
}
