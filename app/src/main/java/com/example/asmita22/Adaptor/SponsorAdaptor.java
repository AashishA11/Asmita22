package com.example.asmita22.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asmita22.Models.SponsorsModel;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SponsorAdaptor extends RecyclerView.Adapter<SponsorAdaptor.viewholder>{
    ArrayList<SponsorsModel> list;
    Context context;

    public SponsorAdaptor(ArrayList<SponsorsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SponsorAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sponsors_sample,parent,false);
        return new SponsorAdaptor.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorAdaptor.viewholder holder, int position) {
        final SponsorsModel model= list.get(position);
<<<<<<< HEAD
        Glide.with(context).load(model.getImg()).into(holder.SponsorImg);
=======
       // holder.SponsorImg.setImageResource(model.getImg());
>>>>>>> e7d9ef341eb9b6fb24c4f86d1e12c44f44384acd
        holder.SponsorName.setText(model.getSponsorName());
//        Picasso.get().load(model.getImg())
//                .fit()
//                .placeholder(R.drawable.asmita_new)
//                .centerCrop()
//                .into(holder.SponsorImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        ImageView SponsorImg;
        TextView SponsorName;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            SponsorImg=itemView.findViewById(R.id.SponsorImage);
            SponsorName=itemView.findViewById(R.id.SponsorName);
        }
    }
}
