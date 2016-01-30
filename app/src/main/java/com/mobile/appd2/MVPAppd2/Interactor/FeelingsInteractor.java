package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

/**
 * Created by david on 29/11/15.
 */
public interface FeelingsInteractor {

    public void saveFeelings(int feeling);

    public void getPreference(SharedPreferences preference);

}
