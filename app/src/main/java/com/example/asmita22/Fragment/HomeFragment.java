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
        list.add(new homeModel(R.drawable.asmita_new,"Burger"));
        list.add(new homeModel(R.drawable.asmita_new,"CHESS"));
        list.add(new homeModel(R.drawable.asmita_new,"CRICKET"));
        list.add(new homeModel(R.drawable.asmita_new,"FOOTBALL"));
        list.add(new homeModel(R.drawable.asmita_new,"COD"));
        list.add(new homeModel(R.drawable.bgmi,"BGMI"));

        homeAdaptor adaptor=new homeAdaptor(list,getContext());
        binding.HomeRV.setAdapter(adaptor);
        GridLayoutManager layoutManager=new GridLayoutManager( getContext(),2);
        //LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        binding.HomeRV.setLayoutManager(layoutManager);
        return  binding.getRoot();
    }
}