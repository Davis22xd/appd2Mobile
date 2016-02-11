package com.mobile.appd2.MVPAppd2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.Holders.RecyclerViewHolders;
import com.mobile.appd2.MVPAppd2.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Feeling> feelingList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Feeling> feelingList) {
        this.feelingList = feelingList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.feelingName.setText(feelingList.get(position).getName());
        holder.feelingPhoto.setImageResource(feelingList.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return this.feelingList.size();
    }
}
