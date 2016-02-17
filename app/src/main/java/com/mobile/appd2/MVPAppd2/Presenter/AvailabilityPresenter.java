package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.SharedPreferences;

/**
 * Created by david on 29/11/15.
 */
public interface AvailabilityPresenter {
    public void saveAvailability(int year,int monthOfYear, int dayOfMonth, int hourOfDay, int minute);
}
