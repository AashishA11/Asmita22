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
import com.example.asmita22.Models.SponsorsModel;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentSponsorsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
        SponserName=(TextView) view.findViewById(R.id.SponsorName);
        SponserImg=(ImageView) view.findViewById(R.id.SponsorImage);
        //SFRV=(RecyclerView) view.findViewById(R.id.SponsorRv);
        ArrayList<SponsorsModel> list=new ArrayList<>();
        list.add(new SponsorsModel(R.drawable.trixxter,"Trixxter"));
        list.add(new SponsorsModel(R.drawable.sketch,"Sketch"));
        list.add(new SponsorsModel(R.drawable.bgmi,"BGMI"));
        list.add(new SponsorsModel(R.drawable.scribble,"Scribble"));
        list.add(new SponsorsModel(R.drawable.sportquiz,"Sports Quiz"));




        DocumentReference documentReference=firestore.collection("Sponsers").document("sp1");

        SponsorAdaptor adaptor=new SponsorAdaptor(list,getContext());
        binding.SponsorRv.setAdapter(adaptor);
        //GridLayoutManager layoutManager=new GridLayoutManager( getContext(),2);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.SponsorRv.setLayoutManager(layoutManager);
        return binding.getRoot();
    }
}