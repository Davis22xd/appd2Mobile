package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.SharedPreferences;

/**
 * Created by david on 29/11/15.
 */
public interface FeelingsPresenter {

    public void saveFeelings(int feeling);
    public void getPreference(SharedPreferences preference);
}
