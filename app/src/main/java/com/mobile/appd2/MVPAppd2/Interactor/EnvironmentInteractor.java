package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

/**
 * Created by david on 29/11/15.
 */
public interface EnvironmentInteractor {

    public void saveEnvironment(int environment);
    public void getPreference(SharedPreferences preference);

}
