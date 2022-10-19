package com.example.fireteranotification.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fireteranotification.R;
import com.example.fireteranotification.model.AppModel;
import java.util.ArrayList;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {

    private final AppInterface appInterfaces;


    Context context;
    ArrayList<AppModel> appModels;

    public AppAdapter(Context context, ArrayList<AppModel> appModels, AppInterface appInterfaces){
        this.context = context;
        this.appModels = appModels;
        this.appInterfaces = appInterfaces;
    }

    @NonNull
    @Override
    public AppAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recylerapp, parent, false);

        return new AppAdapter.MyViewHolder(view, appInterfaces);
    }

    @Override
    public void onBindViewHolder(@NonNull AppAdapter.MyViewHolder holder, int position) {
        holder.apptitle.setText(appModels.get(position).getAppName());
        holder.image.setImageResource(appModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return appModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView apptitle;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, AppInterface appInterfaces) {
            super(itemView);
            apptitle = itemView.findViewById(R.id.appTitle);
            image = itemView.findViewById(R.id.image);



            itemView.setOnClickListener(view -> {
                if(appInterfaces != null ){
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        appInterfaces.onItemClick(pos);
                    }

                }
            });
        }
    }


}
