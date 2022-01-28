package com.example.asmita22.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmita22.Adaptor.SponsorAdaptor;
import com.example.asmita22.Adaptor.homeAdaptor;
import com.example.asmita22.Models.NotificationModel;
import com.example.asmita22.Models.SponsorsModel;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentSponsorsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SponsorsFragment extends Fragment {


    FragmentSponsorsBinding binding;
    FirebaseFirestore firestore;
    private DatabaseReference mDatabaseRef;

    public TextView SponserName;
    public ImageView SponserImg;
    RecyclerView SFRV;
    View view=null;
    public SponsorsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding=FragmentSponsorsBinding.inflate(inflater,container,false);
        view=inflater.inflate(R.layout.fragment_info, container, false);
        firestore=FirebaseFirestore.getInstance();
       // SponserName=(TextView) view.findViewById(R.id.SponsorName);
        //SponserImg=(ImageView) view.findViewById(R.id.SponsorImage);
        //SFRV=(RecyclerView) view.findViewById(R.id.SponsorRv);
        ArrayList<SponsorsModel> list=new ArrayList<>();
//        list.add(new SponsorsModel(R.drawable.trixxter,"Trixxter"));
//        list.add(new SponsorsModel(R.drawable.sketch,"Sketch"));
//        list.add(new SponsorsModel(R.drawable.bgmi,"BGMI"));
//        list.add(new SponsorsModel(R.drawable.scribble,"Scribble"));
//        list.add(new SponsorsModel(R.drawable.sportquiz,"Sports Quiz"));



        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Sponsers");
        SponsorAdaptor adaptor=new SponsorAdaptor(list,getContext());
        //GridLayoutManager layoutManager=new GridLayoutManager( getContext(),2);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.SponsorRv.setLayoutManager(layoutManager);
        binding.SponsorRv.setAdapter(adaptor);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int pos=0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String Name;
                    int Image;
                    Name=postSnapshot.child("Name").getValue().toString();
                   // Image=postSnapshot.child("Image").getValue().toString();
                     list.add(new SponsorsModel(Name));
                    adaptor.notifyItemInserted(pos++);
                }
                // binding.SponsorRv.hideShimmerAdapter();
               // adaptor.notifyDataSetChanged();
//                mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
//
//                mRecyclerView.setAdapter(mAdapter);
//                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });



        return binding.getRoot();
    }
}