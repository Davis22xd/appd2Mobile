package com.mobile.appd2.MVPAppd2.View;

import com.facebook.AccessToken;
import com.facebook.Profile;

/**
 * Created by nando on 10/25/15.
 */
public interface LoginStateView {

    public void displayUserInfo(Profile profile);
    public void onSuccees(String msg);
    public void onError(String msg);
    public void checkLogin(AccessToken accessToken);
    public boolean checkInternetStatus();
}
