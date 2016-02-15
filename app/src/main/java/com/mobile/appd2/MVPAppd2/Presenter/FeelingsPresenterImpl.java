package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Interactor.FeelingsInteractor;
import com.mobile.appd2.MVPAppd2.Interactor.FeelingsInteractorImpl;
import com.mobile.appd2.MVPAppd2.Listener.FeelingsListener;

/**
 * Created by david on 29/11/15.
 */
public class FeelingsPresenterImpl implements FeelingsPresenter, FeelingsListener {

    //private FeelingsStateView FeelingsStateView;

    private FeelingsInteractor FeelingsInterator;
//    public FeelingsPresenterImpl(FeelingsStateView FeelingsStateView) {
//        this.FeelingsStateView = FeelingsStateView;
//        FeelingsInterator = new FeelingsInteractorImpl(FeelingsStateView,this);
//    }

    public FeelingsPresenterImpl() {
        FeelingsInterator = new FeelingsInteractorImpl(this);
    }

    @Override
    public void saveFeelings(int feeling) {
        FeelingsInterator.saveFeelings(feeling);
    }

    @Override
    public void getPreference(SharedPreferences preference) {
       FeelingsInterator.getPreference(preference);
    }

    @Override
    public void onMessageError(String msg) {

    }

}
