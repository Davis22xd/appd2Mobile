package com.mobile.appd2.MVPAppd2.Presenter;

import com.mobile.appd2.MVPAppd2.Interactor.LoginFacebookInterator;
import com.mobile.appd2.MVPAppd2.Interactor.LoginFacebookInteratorImpl;
import com.mobile.appd2.MVPAppd2.Listener.LoginFacebookListener;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;

/**
 * Created by nando on 10/25/15.
 */
public class LoginPrenterImpl implements LoginPresenter, LoginFacebookListener {

    private LoginStateView loginStateView;

    private LoginFacebookInterator loginFacebookInterator;
    public LoginPrenterImpl(LoginStateView loginStateView) {
        this.loginStateView = loginStateView;
        //loginFacebookInterator = new LoginFacebookInteratorImpl();
    }

    @Override
    public void callFacebook() {
      //  loginFacebookInterator.callFacebook(this);
    }

    @Override
    public void onMessageError(String msg) {
        loginStateView.onSuccees(msg);
    }

    @Override
    public void onMessageSucces(String msg) {
        loginStateView.onError(msg);
    }
}
