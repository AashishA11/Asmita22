package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmita22.Adaptor.SponsorAdaptor;
import com.example.asmita22.Adaptor.homeAdaptor;
import com.example.asmita22.Models.SponsorsModel;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentSponsorsBinding;

import java.util.ArrayList;


public class SponsorsFragment extends Fragment {


    FragmentSponsorsBinding binding;
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
        // Inflate the layout for this fragment
        binding=FragmentSponsorsBinding.inflate(inflater,container,false);
        ArrayList<SponsorsModel> list=new ArrayList<>();
        list.add(new SponsorsModel(R.drawable.trixxter,"Trixxter"));
        list.add(new SponsorsModel(R.drawable.sketch,"Sketch"));
        list.add(new SponsorsModel(R.drawable.bgmi,"BGMI"));
        list.add(new SponsorsModel(R.drawable.scribble,"Scribble"));
        list.add(new SponsorsModel(R.drawable.sportquiz,"Sports Quiz"));


        SponsorAdaptor adaptor=new SponsorAdaptor(list,getContext());
        binding.SponsorRv.setAdapter(adaptor);
        //GridLayoutManager layoutManager=new GridLayoutManager( getContext(),2);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.SponsorRv.setLayoutManager(layoutManager);
        return binding.getRoot();
    }
}