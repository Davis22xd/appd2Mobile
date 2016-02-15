package com.mobile.appd2.MVPAppd2.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView feelingName;
    public ImageView feelingPhoto;
    private FeelingsPresenter feelingsPresenter;

    public RecyclerViewHolders(View itemView, FeelingsPresenter presenter) {
        super(itemView);
        itemView.setOnClickListener(this);
        feelingsPresenter = presenter;
        feelingName = (TextView)itemView.findViewById(R.id.feeling_name);
        feelingPhoto = (ImageView)itemView.findViewById(R.id.feeling_photo);
    }

    @Override
    public void onClick(View view) {
        feelingsPresenter.saveFeelings(getPosition());
        Toast.makeText(view.getContext(), "Clicked feeling Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}