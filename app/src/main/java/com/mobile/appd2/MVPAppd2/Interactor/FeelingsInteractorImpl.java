package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mobile.appd2.MVPAppd2.Listener.FeelingsListener;
import com.mobile.appd2.MVPAppd2.View.FeelingsStateView;

import java.util.Calendar;

/**
 * Created by david on 29/11/15.
 */
public class FeelingsInteractorImpl implements FeelingsInteractor {

    private  FeelingsListener FeelingsListener;
    private  SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private FeelingsStateView FeelingsView;

    public int getFeeling() {
        return feeling;
    }

    public void setFeeling(int feeling) {
        this.feeling = feeling;
    }

    private int feeling;

    public FeelingsInteractorImpl(FeelingsStateView FeelingsView, FeelingsListener FeelingsListener) {
        this.FeelingsView = FeelingsView;
        this.FeelingsListener = FeelingsListener;
    }

    @Override
    public void saveFeelings(int feeling) {
        setFeeling(feeling);
        editor.putString("budget", String.valueOf(getFeeling()));
    }

    @Override
    public void getPreference(SharedPreferences preference) {
        sharedpreferences = preference;
        editor = sharedpreferences.edit();
    }

}
