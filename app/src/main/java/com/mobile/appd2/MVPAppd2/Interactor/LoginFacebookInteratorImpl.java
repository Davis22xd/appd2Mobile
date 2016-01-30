package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mobile.appd2.MVPAppd2.Listener.LoginFacebookListener;
import com.mobile.appd2.MVPAppd2.UI.FacebookLoginActivity;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;

/**
 * Created by nando on 10/25/15.
 */
public class LoginFacebookInteratorImpl implements LoginFacebookInterator {
    private CallbackManager callbackManager;

    private AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                   AccessToken currentAccessToken) {
            if (currentAccessToken == null) {
                loginView.checkLogin(currentAccessToken);
            }
        }
    };

    private ProfileTracker profileTracker;
    private LoginStateView loginView;
    private FacebookLoginActivity activity;
    private LoginFacebookListener loginFacebookListener;

    private FacebookCallback<LoginResult> callback  ;

    {
        callback = new FacebookCallback<LoginResult>()  {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                loginFacebookListener.onMessageSucces("Bienvenido a APPD2");
                loginView.displayUserInfo(profile);
                loginView.checkLogin(accessToken);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {
                if(!loginView.checkInternetStatus()){
                    loginFacebookListener.onMessageError("No hay conexión a internet");
                }
            }
        };
    }

    public LoginFacebookInteratorImpl(LoginStateView loginView, LoginFacebookListener loginFacebookListener) {
        this.loginView = loginView;
        this.loginFacebookListener = loginFacebookListener;
    }


    @Override
    public void createNewFacebookInstance() {

        callbackManager = CallbackManager.Factory.create();

        accessTokenTracker= new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                loginView.checkLogin(newToken);
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                loginView.displayUserInfo(newProfile);
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();
    }

    @Override
    public void logIntoFacebook(LoginButton loginButton) {
        loginButton.registerCallback(callbackManager, callback);

    }

    @Override
    public void setResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void stopProfileTracking() {
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

}
