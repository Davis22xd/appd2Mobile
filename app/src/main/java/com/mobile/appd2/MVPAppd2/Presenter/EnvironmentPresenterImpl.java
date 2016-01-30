package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Interactor.AvailabilityInteractorImpl;
import com.mobile.appd2.MVPAppd2.Interactor.AvailabiltyInteractor;
import com.mobile.appd2.MVPAppd2.Interactor.EnvironmentInteractor;
import com.mobile.appd2.MVPAppd2.Interactor.EnvironmentInteractorImpl;
import com.mobile.appd2.MVPAppd2.Listener.AvailabilityListener;
import com.mobile.appd2.MVPAppd2.Listener.EnvironmentListener;
import com.mobile.appd2.MVPAppd2.View.AvailabilityStateView;
import com.mobile.appd2.MVPAppd2.View.EnvironmentStateView;

/**
 * Created by david on 29/11/15.
 */
public class EnvironmentPresenterImpl implements EnvironmentPresenter, EnvironmentListener{

    private EnvironmentStateView environmentStateView;
    private EnvironmentInteractor environmentInterator;

    public EnvironmentPresenterImpl(EnvironmentStateView environmentStateView) {
        this.environmentStateView = environmentStateView;
        environmentInterator = new EnvironmentInteractorImpl(environmentStateView,this);

    }

    @Override
    public void saveEnvironment(int environment) {

       environmentInterator.saveEnvironment(environment);
        environmentStateView.goNextStep();

    }

    @Override
    public void getPreference(SharedPreferences preference) {
        environmentInterator.getPreference(preference);
    }

    @Override
    public void onMessageError(String msg) {

    }
}
