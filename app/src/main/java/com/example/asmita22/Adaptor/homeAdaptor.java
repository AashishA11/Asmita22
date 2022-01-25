package com.example.asmita22.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;

import java.util.ArrayList;

public class homeAdaptor extends RecyclerView.Adapter<homeAdaptor.viewholder> {

    ArrayList<homeModel>list;
    Context context;

    public homeAdaptor(ArrayList<homeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public homeAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_sample,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull homeAdaptor.viewholder holder, int position) {

        final homeModel model= list.get(position);
        holder.EventImg.setImageResource(model.getImg());
        holder.Eventname.setText(model.getEventName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, TrixxterActivity.class);
                intent.putExtra("eventName",model.getEventName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        ImageView EventImg;
        TextView Eventname;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            EventImg=itemView.findViewById(R.id.EventImg);
            Eventname=itemView.findViewById(R.id.EventName);
        }
    }
}
