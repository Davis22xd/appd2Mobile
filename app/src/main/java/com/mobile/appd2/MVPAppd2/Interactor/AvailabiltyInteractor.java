package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

/**
 * Created by david on 29/11/15.
 */
public interface AvailabiltyInteractor {

    void saveAvailability(int year,int monthOfYear, int dayOfMonth, int hourOfDay, int minute);

//    public void getPreference(SharedPreferences preference);

}
