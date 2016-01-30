package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.Intent;

import com.facebook.login.widget.LoginButton;
import com.mobile.appd2.MVPAppd2.Listener.LoginFacebookListener;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;
import com.mobile.appd2.MVPAppd2.Interactor.LoginFacebookInterator;
import com.mobile.appd2.MVPAppd2.Interactor.LoginFacebookInteratorImpl;


/**
 * Created by david on 3/1/16.
 */
public class FacebookLoginPresenterImpl implements FacebookLoginPresenter, LoginFacebookListener {
    private LoginStateView loginView;
    private LoginFacebookInterator loginInteractor;

    public FacebookLoginPresenterImpl(LoginStateView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginFacebookInteratorImpl(loginView, this);
    }

    @Override
    public void callFacebook(LoginButton loginButton) {
        loginInteractor.logIntoFacebook(loginButton);
    }

    @Override
    public void setResult(int requestCode, int resultCode, Intent data) {
        loginInteractor.setResult(requestCode,resultCode,data);
    }

    @Override
    public void stopTracking() {
        loginInteractor.stopProfileTracking();
    }

    @Override
    public void createNewFacebookInstance() {
        loginInteractor.createNewFacebookInstance();
    }

    @Override
    public void onMessageError(String msg) {
        loginView.onError(msg);
    }

    @Override
    public void onMessageSucces(String msg) {
        loginView.onSuccees(msg);
    }
}
