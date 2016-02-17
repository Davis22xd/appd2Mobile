package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Interactor.AvailabiltyInteractor;
import com.mobile.appd2.MVPAppd2.Interactor.AvailabilityInteractorImpl;
import com.mobile.appd2.MVPAppd2.Listener.AvailabilityListener;
import com.mobile.appd2.MVPAppd2.View.AvailabilityStateView;

/**
 * Created by david on 29/11/15.
 */
public class AvailabilityPresenterImpl implements AvailabilityPresenter, AvailabilityListener {

    private AvailabilityStateView AvailabilityStateView;

    private AvailabiltyInteractor AvailabilityInterator;
    public AvailabilityPresenterImpl(AvailabilityStateView AvailabilityStateView) {
        this.AvailabilityStateView = AvailabilityStateView;
        AvailabilityInterator = new AvailabilityInteractorImpl(AvailabilityStateView,this);
    }

    @Override
    public void saveAvailability(int year,int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
        AvailabilityInterator.saveAvailability(year, monthOfYear, dayOfMonth, hourOfDay, minute);

    }


    @Override
    public void onMessageError(String msg) {
        AvailabilityStateView.onError(msg);
    }

}
