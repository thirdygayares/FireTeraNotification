package com.example.fireteranotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AppHolder extends AppCompatActivity {

    ImageView back,background;
    TextView created, creator, descrition,location,title;
    Button open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_holder);

//        initialize
        initxml();
//        back
        back();

        //open a notification
        openNotif();

        Intent intent = getIntent();
        int bg = intent.getIntExtra("background", -1);

        //set Image
        background.setImageResource(bg);
        //set Text of app title
        title.setText(intent.getStringExtra("appName"));
        //set Text of app created
        created.setText(intent.getStringExtra("created"));
        //set Text of app creator
        creator.setText(intent.getStringExtra("creator"));
        //set Text of app brief description
        descrition.setText(intent.getStringExtra("description"));
        //set Text of app created
        location.setText(intent.getStringExtra("location"));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(intent.getStringExtra("appName"), "my notif", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


    }

    private void openNotif() {
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });
    }


    private void notification() {

        Intent getData = getIntent();
        int icon = getData.getIntExtra("icon", -1);
        int color = getData.getIntExtra("color", -1);
        String name = getData.getStringExtra("appName");
        String description = getData.getStringExtra("description");
        String app = getData.getStringExtra("app");

        Intent intent = new Intent(  this, NotificationVIew.class);
        intent.putExtra("apps", app);


        intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity( this,  0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder( AppHolder.this, name)
                .setSmallIcon(icon).setContentTitle(name).setColor(ContextCompat.getColor(AppHolder.this, color))
                .setContentText(description)
                .setPriority (NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent).setAutoCancel(true);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(  0, builder.build());

    }

    private void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initxml() {
        back = findViewById(R.id.back);
        background = findViewById(R.id.background);
        created = findViewById(R.id.create);
        creator = findViewById(R.id.creator);
        descrition = findViewById(R.id.about);
        location = findViewById(R.id.location);
        title= findViewById(R.id.appName);
        open = findViewById(R.id.open);
    }



}