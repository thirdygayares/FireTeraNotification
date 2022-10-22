package com.example.fireteranotification;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler handler =new Handler();
        handler.postDelayed(new Runnable () {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Home.class));
                finish();
            }
        },  2000) ;



    }
}