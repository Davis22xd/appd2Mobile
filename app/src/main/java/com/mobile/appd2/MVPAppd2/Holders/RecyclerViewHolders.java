package com.mobile.appd2.MVPAppd2.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView feelingName;
    public ImageView feelingPhoto;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        feelingName = (TextView)itemView.findViewById(R.id.feeling_name);
        feelingPhoto = (ImageView)itemView.findViewById(R.id.feeling_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked feeling Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}