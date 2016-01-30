package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.Context;
import android.content.Intent;

import com.facebook.login.widget.LoginButton;
import com.mobile.appd2.MVPAppd2.Listener.LoginFacebookListener;

/**
 * Created by nando on 10/25/15.
 */
public interface LoginFacebookInterator {

    //public void callFacebook(LoginFacebookListener loginFacebookListener);
    public void createNewFacebookInstance();
    public void logIntoFacebook(LoginButton loginButton);
    public void setResult(int requestCode, int resultCode, Intent data);
    public void stopProfileTracking();
}
