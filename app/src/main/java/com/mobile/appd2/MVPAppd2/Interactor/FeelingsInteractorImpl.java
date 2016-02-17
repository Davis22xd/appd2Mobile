package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mobile.appd2.MVPAppd2.Listener.FeelingsListener;
import com.mobile.appd2.MVPAppd2.View.FeelingsStateView;

/**
 * Created by david on 29/11/15.
 */
public class FeelingsInteractorImpl implements FeelingsInteractor {

    private  FeelingsListener FeelingsListener;
    private  SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private FeelingsStateView FeelingsView;


    public FeelingsInteractorImpl(FeelingsStateView feelingsStateView, FeelingsListener FeelingsListener) {
        this.FeelingsListener = FeelingsListener;
        this.FeelingsView = feelingsStateView;
    }

    @Override
    public void saveFeelings(int feeling) {
        FeelingsView.showConfirmationPlan(getNameMood(feeling));
    }

    private String getNameMood (int feeling){
        String moodName;
        switch (feeling) {
            case 0:  moodName = "Alternativo";
                break;
            case 1:  moodName = "Aventurero";
                break;
            case 2:  moodName = "Romantico";
                break;
            case 3:  moodName = "Relajado";
                break;
            case 4:  moodName = "Loco";
                break;
            case 5:  moodName = "Elegante";
                break;
            default: moodName = "";
                break;
        }

        return moodName;
    }

}
