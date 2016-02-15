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


    private enum feelings {

        ALTERNATIVO("Alternativo"),
        AVENTURERO("Aventurero"),
        ROMANTICO("Romántico"),
        RELAJADO("Relajado"),
        LOCO("Loco"),
        ELEGANTE("Elegante");

        private final String text;

        /**
         * @param text
         */
        private feelings(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }

    }

    public FeelingsInteractorImpl(FeelingsListener FeelingsListener) {
        this.FeelingsListener = FeelingsListener;
    }

    @Override
    public void saveFeelings(int feeling) {
        editor.putString("feeling",getNameMood(feeling));
        printDatafromPreference();
    }

    @Override
    public void getPreference(SharedPreferences preference) {
        sharedpreferences = preference;
        editor = sharedpreferences.edit();
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

    private void printDatafromPreference (){
        String feeling = "com.mobile.appd2.MVPAppd2.feeling";
        feeling =sharedpreferences.getString(feeling, new String());
        Log.d("Feelings interactor: ",feeling);
    }

}
