package com.example.asmita22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.asmita22.Adaptor.homeAdaptor;
import com.example.asmita22.Fragment.HomeFragment;
import com.example.asmita22.Fragment.NotificationFragment;
import com.example.asmita22.Fragment.SponsorsFragment;
import com.example.asmita22.Fragment.TeamFragment;
import com.example.asmita22.Models.homeModel;
import com.example.asmita22.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,new HomeFragment());
        transaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportActionBar().hide();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        transaction.replace(R.id.fragment_container,new HomeFragment());
                        break;
                    case R.id.navigation_notifications:
                        transaction.replace(R.id.fragment_container,new NotificationFragment());
                        break;
                    case R.id.plus:
                        transaction.replace(R.id.fragment_container,new SponsorsFragment());
                        break;

                    case R.id.user:
                        transaction.replace(R.id.fragment_container,new TeamFragment());
                        break;
                }
                transaction.commit();
                return true;
            }
        });

}
}