package com.mobile.appd2.MVPAppd2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.Holders.RecyclerViewHolders;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenter;
import com.mobile.appd2.MVPAppd2.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Feeling> feelingList;
    private Context context;
    private AdapterView.OnItemClickListener listener;
    private FeelingsPresenter feelingsPresenter;

    public RecyclerViewAdapter(Context context, List<Feeling> feelingList, FeelingsPresenter presenter ) {
        this.feelingList = feelingList;
        this.context = context;
        feelingsPresenter = presenter;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView,feelingsPresenter);
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

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

}
