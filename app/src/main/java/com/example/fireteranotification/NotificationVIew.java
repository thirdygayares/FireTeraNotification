package com.example.fireteranotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificationVIew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        Intent getData = getIntent();
        String app = getData.getStringExtra("apps");


        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(NotificationVIew.this, "There is no package available in android", Toast.LENGTH_LONG).show();
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