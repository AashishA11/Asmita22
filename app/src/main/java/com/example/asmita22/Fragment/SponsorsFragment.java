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
import com.google.firebase.firestore.CollectionReference;

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

import org.w3c.dom.Document;

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
        CollectionReference Reference=firestore.collection("Sponsers");
        SponsorAdaptor adaptor=new SponsorAdaptor(list,getContext());
        binding.SponsorRv.setAdapter(adaptor);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.SponsorRv.setLayoutManager(layoutManager);
        Reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int pos=0;
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        SponsorsModel model=new SponsorsModel(document.getString("Image"),document.getString("Name"),document.getString("link"));
                        list.add(model);
                        adaptor.notifyItemInserted(pos++);
                    }
                } else {
                    Toast.makeText(getContext(), "Please try again later", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
}
