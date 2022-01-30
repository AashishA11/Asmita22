package com.example.asmita22.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        String uri= model.getImg();
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource);
        holder.img.setImageDrawable(res);
        if(model.getName().equals("Dr. Sunnel Yadav")){
            String ur="@drawable/ic_mail_foreground";
            int imgResource = context.getResources().getIdentifier(ur, null, context.getPackageName());
            Drawable re = context.getResources().getDrawable(imgResource);
            holder.mail.setImageDrawable(re);
        }
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(model.getName().equals("Dr. Sunnel Yadav")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "fi.sports@iiita.ac.in" });
                    context.startActivity(Intent.createChooser(intent, ""));
                }
                else {
                    String phone = model.getMail();
                    Uri u = Uri.parse("tel:" + phone);
                    Intent i = new Intent(Intent.ACTION_DIAL, u);
                    try {
                        context.startActivity(i);
                    } catch (SecurityException s) {
                        Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
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
