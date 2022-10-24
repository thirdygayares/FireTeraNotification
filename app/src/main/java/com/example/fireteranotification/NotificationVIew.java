package com.example.fireteranotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificationVIew extends AppCompatActivity {
    //the package name
    String[] app = {"com.google.android.calculator","com.android.chrome", "com.facebook.katana","com.grabtaxi.passenger", "com.instagram.android","com.lazada.android", "com.linkedin.android","com.facebook.orca","com.mobile.legends", "com.netflix.mediaclient", "com.shopee.ph", "com.google.android.apps.messaging", "com.spotify.music", "org.telegram.messenger", "com.ss.android.ugc.trill", "com.twitter.android", "com.viber.voip", "com.google.android.youtube" };

    //    incase the app is not installed to the current user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        Intent getData = getIntent();
        int appx = getData.getIntExtra("notifApps", -1);

        Home lagayan = new Home();
       int x = lagayan.container;

//        Toast.makeText(NotificationVIew.this, "the app is " + x, Toast.LENGTH_SHORT).show();


        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(app[x]);
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Intent intent = new Intent(NotificationVIew.this, WebView.class);
            startActivity(intent);
        }

    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(NotificationVIew.this, Home.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


}