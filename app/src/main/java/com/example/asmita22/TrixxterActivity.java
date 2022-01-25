package com.example.asmita22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.asmita22.Adaptor.fragmentAdaptor;
import com.google.android.material.tabs.TabLayout;

public class TrixxterActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TextView EventName;
     String Event_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trixxter);
        EventName=findViewById(R.id.trixxter_event_name);
        Event_name=getIntent().getStringExtra("eventName");

        EventName.setText(Event_name);
        getSupportActionBar().hide();
        viewPager=findViewById(R.id.ViewPager);
        viewPager.setAdapter(new fragmentAdaptor(getSupportFragmentManager()));
        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
   public String getName(){
        return Event_name;
    }
}