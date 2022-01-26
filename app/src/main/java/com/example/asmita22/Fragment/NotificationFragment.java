package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmita22.Adaptor.notificationAdaptor;
import com.example.asmita22.Adaptor.teamAdaptor;
import com.example.asmita22.Models.NotificationModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentNotificationBinding;
import com.example.asmita22.databinding.FragmentTeamBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    FragmentNotificationBinding binding;
    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        firebaseDatabase=FirebaseDatabase.getInstance();
        binding = FragmentNotificationBinding.inflate(inflater,container,false);
        ArrayList<NotificationModel> arrayList=new ArrayList<>();
        DatabaseReference reference=firebaseDatabase.getReference().child("Updates");
        notificationAdaptor adaptor=new notificationAdaptor(arrayList,getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getContext());
        binding.NotiRV.setLayoutManager(layoutManager);
        binding.NotiRV.setAdapter(adaptor);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int pos=0;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String date,event,info;
                    date=dataSnapshot.child("Date").getValue().toString();
                    event=dataSnapshot.child("Event").getValue().toString();
                    info=dataSnapshot.child("Info").getValue().toString();
                    arrayList.add(new NotificationModel(event,date,info));
                    adaptor.notifyItemInserted(pos++);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return binding.getRoot();
    }
}