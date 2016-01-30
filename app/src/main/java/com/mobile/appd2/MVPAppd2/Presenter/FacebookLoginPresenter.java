package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.Intent;

import com.facebook.login.widget.LoginButton;

/**
 * Created by david on 3/1/16.
 */
public interface FacebookLoginPresenter {
    public void callFacebook(LoginButton loginButton);
    public void setResult(int requestCode, int resultCode, Intent data);
    public void stopTracking();
    public void createNewFacebookInstance();

}
