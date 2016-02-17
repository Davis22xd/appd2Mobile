package com.mobile.appd2.MVPAppd2.CustomViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.Holders.RecyclerViewHolders;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenter;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.FeelingsActivity;
import com.mobile.appd2.MVPAppd2.View.FeelingsStateView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Feeling> feelingList;
    private Context context;
    private AdapterView.OnItemClickListener listener;
    private FeelingsPresenter feelingsPresenter;
    private static FeelingsStateView itemListener;

    public RecyclerViewAdapter(Context context, List<Feeling> feelingList, FeelingsStateView itemListener ) {
        this.feelingList = feelingList;
        this.context = context;
        this.itemListener = itemListener;

    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        return new RecyclerViewHolders(layoutView,this);
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

    public void recyclerViewListClicked(View v, int position) {
        itemListener.recyclerViewListClicked(v, position);
    }
}
