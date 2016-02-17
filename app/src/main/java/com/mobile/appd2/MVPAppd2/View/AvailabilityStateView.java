package com.mobile.appd2.MVPAppd2.View;

/**
 * Created by david on 29/11/15.
 */
public interface AvailabilityStateView {
    void goNextStep(String date, int hour, int minute);
    void onError(String msg);
}
