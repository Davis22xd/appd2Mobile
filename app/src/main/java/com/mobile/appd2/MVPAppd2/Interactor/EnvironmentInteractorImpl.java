package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Listener.BudgetListener;
import com.mobile.appd2.MVPAppd2.Listener.EnvironmentListener;
import com.mobile.appd2.MVPAppd2.View.EnvironmentStateView;

import java.util.UUID;

/**
 * Created by david on 29/11/15.
 */
public class EnvironmentInteractorImpl implements EnvironmentInteractor {

    private EnvironmentListener environmentListener;
    private  SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private EnvironmentStateView environmentStateView;

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    private  int environment;

    public EnvironmentInteractorImpl(EnvironmentStateView environmentView, EnvironmentListener environmentListener) {
        this.environmentStateView = environmentView;
        this.environmentListener = environmentListener;
    }

    @Override
    public void saveEnvironment(int environment) {
        setEnvironment(environment);
        editor.putString("environment", String.valueOf(getEnvironment()));
        System.out.println("la clave es: " + environment);
    }

    @Override
    public void getPreference(SharedPreferences preference) {
        sharedpreferences = preference;
        editor = sharedpreferences.edit();
    }
}
