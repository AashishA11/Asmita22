package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmita22.Adaptor.teamAdaptor;
import com.example.asmita22.Models.TeamModel;
import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;
import com.example.asmita22.databinding.FragmentOrgnaziersBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class OrgnaziersFragment extends Fragment {
    FragmentOrgnaziersBinding binding;
    FirebaseFirestore firestore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOrgnaziersBinding.inflate(inflater,container,false);
        firestore=FirebaseFirestore.getInstance();
        TrixxterActivity activity = (TrixxterActivity) getActivity();
        String eventName = activity.getName();
        ArrayList<TeamModel> arrayList=new ArrayList<>();
        teamAdaptor adaptor=new teamAdaptor(arrayList,getContext());
        DocumentReference reference=firestore.collection("Organizers").document(eventName);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                int pos=0;
                if(!documentSnapshot.getString("org1").equals("-1")) {
                    String name=documentSnapshot.getString("org1");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
                if(!documentSnapshot.getString("org2").equals("-1")) {
                    String name=documentSnapshot.getString("org2");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
                if(!documentSnapshot.getString("org3").equals("-1")) {
                    String name=documentSnapshot.getString("org3");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
                if(!documentSnapshot.getString("org4").equals("-1")) {
                    String name=documentSnapshot.getString("org4");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
                if(!documentSnapshot.getString("org5").equals("-1")) {
                    String name=documentSnapshot.getString("org5");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
                if(!documentSnapshot.getString("org6").equals("-1")) {
                    String name=documentSnapshot.getString("org6");
                    String pic="@drawable/"+name.substring(0,3);
                    String phone=name.substring(3,13);
                    name=name.substring(13);
                    System.out.println("Name :"+name +" "+"Pic :"+pic);
                    arrayList.add(new TeamModel(pic,name,"Team Asmita 2022",phone));
                    adaptor.notifyItemInserted(pos++);
                }
            }
        });
        binding.OrganizerRV.setAdapter(adaptor);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getContext());
        binding.OrganizerRV.setLayoutManager(layoutManager);
        return binding.getRoot();
    }
}