package com.example.fireteranotification;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recylerviewApp);
        setAppData();

        AppAdapter adapter = new AppAdapter(Home.this, appModels, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);



    }

    private void setAppData() {

        String[] title = {"Calculator","SMS", "Youtube","Facebook", "Instagram","Twitter", "Chrome","Lazada" };
        int[] image = {R.drawable.calculator, R.drawable.sms, R.drawable.youtube, R.drawable.facebook, R.drawable.instagram, R.drawable.twitter, R.drawable.chrome, R.drawable.lazada,   };



        for(int i=0; i<title.length; i++){
            appModels.add(new AppModel(title[i],image[i]
            ));
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(Home.this, "click", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(GroupPage.this, GroupPage.class);
//        intent.putExtra("salesId", historyDataModels.get(position).getSalesID());
//        intent.putExtra("Total", historyDataModels.get(position).getTotalPrice());
//        startActivity(intent);
    }
}