package com.example.asmita22;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,MainActivity.class);
                //Intent is used to switch from one activity to another.
                startActivity(i);
                //invoke the SecondActivity.
                finish();
                //the current activity will get finished.
            }
        }, 1500);
    }
}