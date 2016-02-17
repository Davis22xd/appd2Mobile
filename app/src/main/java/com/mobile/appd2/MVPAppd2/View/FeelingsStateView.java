package com.mobile.appd2.MVPAppd2.View;

import android.view.View;

/**
 * Created by david on 29/11/15.
 */
public interface FeelingsStateView {
    void goNextStep();
    void onError(String msg);
    void recyclerViewListClicked(View v, int position);
    void showConfirmationPlan(String feeling);
}
