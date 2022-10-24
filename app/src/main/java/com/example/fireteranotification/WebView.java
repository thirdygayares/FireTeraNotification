package com.example.fireteranotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebView extends AppCompatActivity {
    android.webkit.WebView myWebView;
    String[] web = {"https://play.google.com/store/apps/details?id=com.google.android.calculator","https://play.google.com/store/apps/details?id=com.android.chrome", "https://play.google.com/store/apps/details?id=com.facebook.katana","https://play.google.com/store/apps/details?id=com.grabtaxi.passenger", "https://play.google.com/store/apps/details?id=com.instagram.android","https://play.google.com/store/apps/details?id=com.lazada.android", "https://play.google.com/store/apps/details?id=com.linkedin.android","https://play.google.com/store/apps/details?id=com.facebook.orca","https://play.google.com/store/apps/details?id=com.mobile.legends", "https://play.google.com/store/apps/details?id=com.netflix.mediaclient", "https://play.google.com/store/apps/details?id=com.shopee.ph", "https://play.google.com/store/apps/details?id=com.google.android.apps.messaging", "https://play.google.com/store/apps/details?id=com.spotify.music", "https://play.google.com/store/apps/details?id=org.telegram.messenger", "https://play.google.com/store/apps/details?id=com.ss.android.ugc.trill", "https://play.google.com/store/apps/details?id=com.twitter.android", "https://play.google.com/store/apps/details?id=com.viber.voip", "https://play.google.com/store/apps/details?id=com.google.android.youtube" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Home anongilalabas = new Home();
        int lalagyan = anongilalabas.container;

        myWebView = (android.webkit.WebView) findViewById(R.id.webview);
        myWebView.loadUrl(web[lalagyan]);
    }
}