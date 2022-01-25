package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.asmita22.Adaptor.teamAdaptor;
import com.example.asmita22.Models.TeamModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentHomeBinding;
import com.example.asmita22.databinding.FragmentTeamBinding;

import java.util.ArrayList;


public class TeamFragment extends Fragment {


    FragmentTeamBinding binding;
    public TeamFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTeamBinding.inflate(inflater,container,false);
        ArrayList<TeamModel> arrayList=new ArrayList<>();
        String img="";
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Harsh Bhardwaj", "President","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel(img,"Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        teamAdaptor adaptor=new teamAdaptor(arrayList,getContext());
        binding.TeamRV.setAdapter(adaptor);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getContext());
        binding.TeamRV.setLayoutManager(layoutManager);
        return  binding.getRoot();
    }
}