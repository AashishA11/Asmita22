package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmita22.Adaptor.homeAdaptor;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false);
        ArrayList<homeModel> list=new ArrayList<>();
        list.add(new homeModel(R.drawable.bgmi,"BGMI"));
        list.add(new homeModel(R.drawable.valorent,"Valorant"));
        list.add(new homeModel(R.drawable.smashkarts,"Smash Karts"));
        list.add(new homeModel(R.drawable.chess,"Chess"));
        list.add(new homeModel(R.drawable.trixxter,"Trixxter"));
        list.add(new homeModel(R.drawable.sketch,"Sketch"));
        list.add(new homeModel(R.drawable.challengeweek,"Challenge Week"));
        list.add(new homeModel(R.drawable.scribble,"Scribble"));
        list.add(new homeModel(R.drawable.sportquiz,"Sports Quiz"));
        list.add(new homeModel(R.drawable.rocketleaguea,"Rocket League"));
        list.add(new homeModel(R.drawable.auction,"Auction"));


        homeAdaptor adaptor=new homeAdaptor(list,getContext());
        binding.HomeRV.setAdapter(adaptor);
        GridLayoutManager layoutManager=new GridLayoutManager( getContext(),2);
        //LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        binding.HomeRV.setLayoutManager(layoutManager);
        return  binding.getRoot();
    }
}