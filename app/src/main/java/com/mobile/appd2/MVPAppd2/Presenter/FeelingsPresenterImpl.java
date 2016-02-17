package com.mobile.appd2.MVPAppd2.Presenter;

import com.mobile.appd2.MVPAppd2.Interactor.FeelingsInteractor;
import com.mobile.appd2.MVPAppd2.Interactor.FeelingsInteractorImpl;
import com.mobile.appd2.MVPAppd2.Listener.FeelingsListener;
import com.mobile.appd2.MVPAppd2.View.FeelingsStateView;

/**
 * Created by david on 29/11/15.
 */
public class FeelingsPresenterImpl implements FeelingsPresenter, FeelingsListener {

    private FeelingsStateView FeelingsView;

    private FeelingsInteractor FeelingsInterator;
    public FeelingsPresenterImpl(FeelingsStateView FeelingsStateView) {
        this.FeelingsView = FeelingsStateView;
        FeelingsInterator = new FeelingsInteractorImpl(FeelingsView,this);
    }

    @Override
    public void saveFeelings(int feeling) {
        FeelingsInterator.saveFeelings(feeling);
    }

    @Override
    public void onMessageError(String msg) {

    }

}
