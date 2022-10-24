package com.example.fireteranotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.fireteranotification.Adapter.AppAdapter;
import com.example.fireteranotification.Adapter.AppInterface;
import com.example.fireteranotification.model.AppModel;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements AppInterface {
    ArrayList<AppModel> appModels = new ArrayList<>();
    RecyclerView recyclerView;
    static int container = 0;
    String[] title = {"Calculator","Chrome", "Facebook","Grab", "Instagram","Lazada", "Linkedin","Messenger","Mobile Legends", "Netflix", "Shopee", "SMS", "Spotify", "Telegram", "Tiktok", "Twitter", "Viber", "Youtube" };
    String[] location = {"French", "USA", "Massachusetts USA", "Singapore", "San Francisco USA", "Singapore", "United States", "USA", "China","California USA","Singapore","Germany","Swedish","Germany","China","California USA","Japan","America" };
    String[] description = {"The first mechanical calculator was invented by Blaise Pascal in the early 1600s. Pascal's calculator was able to add, subtract, multiply, and divide",
            "Chrome is designed to be the fastest web browser. With one click, it loads web pages, multiple tabs, and applications with lightning speed.",
            "Facebook is a website that enables users to share their views and opinions with any number of people they choose, along with images, music, videos, and articles.",
            "Grab delivers food, groceries, and acts as an express connecting everything to the doorstep of users",
            "People can upload photos or videos to our service and share them with their followers or with a select group of friends. They can also view, comment and like posts shared by their friends on Instagram.",
            "Lazada.com is part of the Lazada Group, which operates Southeast Asia's leading online shopping and selling destination.",
            "Use LinkedIn to find the right job or internship, connect and strengthen professional relationships, and learn the skills you need to succeed in your career.",
            "A messenger app is any app that enables a private messaging function between two or more people.",
            "The role is there are two group fights to reach and destroy the enemy's castle while defending their own castle to defend the castle they have to control the path they pass through.",
            "Netflix is a subscription-based streaming service that allows our members to watch TV shows and movies without commercials on an internet-connected device.",
            "E-commerce platform tailored for the region, providing customers with an easy, secure and fast online shopping experience through strong payment and fulfillment support.",
            "Android SMS is a native service that allows you to receive Short Message Service (SMS) messages on your device and send messages to other phone numbers.",
            "Spotify is a digital music, podcast, and video service that gives you access to millions of songs and other content from creators all over the world. ",
            "Telegram is a globally accessible freemium, cross-platform, cloud-based instant messaging (IM) service.",
            "TikTok is a social media platform for creating, sharing and discovering short videos.",
            "Connect its users and allow them to share their thoughts with their followers and others through the use of hashtags. It can be a source of news, entertainment and a marketing tool for businesses.",
            "What is Viber and how does it work?\n" +
                    "Viber is a calling and messaging app that connects people–no matter who they are, or where they're from.",
            "YouTube's mission is to give everyone a voice and show them the world. Learn about our brand, community, careers and more.",
    };
    String[] created = {"1642",  "2008",  "2004",  "2012",  "2010",  "2012",  "2002",  "2011",  "2016",  "1997",  "2015",  "1986",  "2006",  "2013",  "2016",  "2006",  "2010",  "2005"};
    String[] creator = {"Blaise Pascal", "Google, Inc.",  "Mark Zuckerberg",  "Anthony Tan\n" +
            "Tan Hooi Ling",  "Kevin Systrom\n" +
            " Mike Krieger",  "Rocket Internet",  "Reid Hoffman's",  "Meta Platforms",  "Moonton",  "Marc Randolph \n" +
            "Reed Hastings",  "Forrest Li",  "Franco-German \n" +
            "GSM cooperation",  "Daniel Ek\n" +
            " Martin Lorentzon",  " Nikolai and \n" +
            "Pavel Durov",  "Zhang Yiming",  "Jack Dorsey\n" +
            "Noah Glass\n" +
            "Biz Stone\n" +
            "Evan Williams",  " Marco and\n" +
            " Magazinnik",  "Steve Chen, \n" +
            "Chad Hurley, \n" +
            "and Jawed Karim"};

    //the package name
    String[] app = {"com.android.calculator","com.android.chrome", "com.facebook.katana","com.grabtaxi.passenger", "com.instagram.android","com.lazada.android", "com.linkedin.android","com.facebook.orca","com.mobile.legends", "com.netflix.mediaclient", "com.shopee.ph", "com.google.apps.messaging", "com.spotify.music", "org.telegram.messenger", "com.ss.android.ugc.trill", "com.twitter.android", "com.viber.voip", "com.google.android.youtube" };

//    incase the app is not installed to the current user
    String[] web = {"https://play.google.com/store/apps/details?id=com.google.android.calculator","https://play.google.com/store/apps/details?id=com.android.chrome", "https://play.google.com/store/apps/details?id=com.facebook.katana","https://play.google.com/store/apps/details?id=com.grabtaxi.passenger", "https://play.google.com/store/apps/details?id=com.instagram.android","https://play.google.com/store/apps/details?id=com.lazada.android", "https://play.google.com/store/apps/details?id=com.linkedin.android","https://play.google.com/store/apps/details?id=com.facebook.orca","https://play.google.com/store/apps/details?id=com.mobile.legends", "https://play.google.com/store/apps/details?id=com.netflix.mediaclient", "https://play.google.com/store/apps/details?id=com.shopee.ph", "https://play.google.com/store/apps/details?id=com.google.android.apps.messaging", "https://play.google.com/store/apps/details?id=com.spotify.music", "https://play.google.com/store/apps/details?id=org.telegram.messenger", "https://play.google.com/store/apps/details?id=com.ss.android.ugc.trill", "https://play.google.com/store/apps/details?id=com.twitter.android", "https://play.google.com/store/apps/details?id=com.viber.voip", "https://play.google.com/store/apps/details?id=com.google.android.youtube" };

    //the icon small in notication
    int[] icon = {R.drawable.calculatoricon, R.drawable.chromeicon , R.drawable.facebookicon  , R.drawable.grabicon , R.drawable.instagramicon , R.drawable.lazadaicon , R.drawable.linkedinicon , R.drawable.messengericon , R.drawable.mobilelegendicon , R.drawable.netflixicon , R.drawable.shopeeicon , R.drawable.smsicon , R.drawable.spotifyicon , R.drawable.telegramicon , R.drawable.tiktokicon , R.drawable.twittericon , R.drawable.vibericon , R.drawable.youtubeicon };

    //the color of icon
    int[] colorIcon = {R.color.calculator, R.color.chrome, R.color.facebook,R.color.grab, R.color.instagram, R.color.lazada, R.color.linkedin, R.color.messenger, R.color.mobilelegends, R.color.netflix, R.color.shopee, R.color.sms,  R.color.spotify,  R.color.telegram,  R.color.tiktok,  R.color.twitter,  R.color.viber,  R.color.youtube };

    // the background image
    int[] background = {R.drawable.calculatorbg,R.drawable.chromebg , R.drawable.facebookbg , R.drawable.grabbg , R.drawable.instagrambg , R.drawable.lazadabg , R.drawable.linkedinbg , R.drawable.messengerbg , R.drawable.mobilelegendsbg , R.drawable.netflixbg , R.drawable.shopeebg , R.drawable.smsbg1 , R.drawable.spotifybg , R.drawable.telegrambg , R.drawable.tiktokbg , R.drawable.twitterbg , R.drawable.viberbg , R.drawable.youtubebg ,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recylerviewApp);
        setAppData();
        AppAdapter adapter = new AppAdapter(Home.this, appModels, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void setAppData() {

        int[] image = {R.drawable.calculator, R.drawable.chrome, R.drawable.facebook, R.drawable.grab, R.drawable.instagram, R.drawable.lazada, R.drawable.linkedin, R.drawable.messenger, R.drawable.mobilelegends, R.drawable.netflix,  R.drawable.shopee, R.drawable.sms, R.drawable.spotify, R.drawable.telegram, R.drawable.tiktok, R.drawable.twitter, R.drawable.viber, R.drawable.youtube      };
        for(int i=0; i<title.length; i++){
            appModels.add(new AppModel(title[i],image[i]
            ));
        }
    }

    @Override
    public void onItemClick(int position) {
//        Toast.makeText(Home.this, "click", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Home.this, AppHolder.class);
//        passing the data
        intent.putExtra("appName", title[position]);
        intent.putExtra("background", background[position]);
        intent.putExtra("created", created[position]);
        intent.putExtra("creator", creator[position]);
        intent.putExtra("description", description[position]);
        intent.putExtra("location", location[position]);


        //pass the data of android packagename
        intent.putExtra("app", app[position]);

        //int
        intent.putExtra("pos", position);
        container = position;


        //pass the data of web incase the current app is not isntalled
        intent.putExtra("web", web[position]);

        //pass the icon for notification
        intent.putExtra("icon", icon[position]);

        //pass the color icon for notification
        intent.putExtra("color", colorIcon[position]);

//        Toast.makeText(Home.this, app[position], Toast.LENGTH_SHORT).show();


        startActivity(intent);
    }
}