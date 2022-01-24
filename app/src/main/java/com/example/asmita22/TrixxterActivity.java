package com.example.asmita22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.asmita22.Adaptor.fragmentAdaptor;
import com.google.android.material.tabs.TabLayout;

public class TrixxterActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trixxter);

        getSupportActionBar().hide();
        viewPager=findViewById(R.id.ViewPager);
        viewPager.setAdapter(new fragmentAdaptor(getSupportFragmentManager()));
        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}