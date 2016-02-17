package com.mobile.appd2.MVPAppd2.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.App;
import com.mobile.appd2.MVPAppd2.CustomViews.CustomDialog;
import com.mobile.appd2.MVPAppd2.CustomViews.RecyclerViewAdapter;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.FeelingsActivity;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView feelingName;
    public ImageView feelingPhoto;
    private static RecyclerViewAdapter itemListener;

    public RecyclerViewHolders(View itemView, RecyclerViewAdapter viewAdapter) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.itemListener = viewAdapter;
        feelingName = (TextView)itemView.findViewById(R.id.feeling_name);
        feelingPhoto = (ImageView)itemView.findViewById(R.id.feeling_photo);

    }


    @Override
    public void onClick(View v)
    {
        itemListener.recyclerViewListClicked(v, this.getPosition());

    }
}