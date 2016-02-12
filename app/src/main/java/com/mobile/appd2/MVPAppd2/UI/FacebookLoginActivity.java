package com.mobile.appd2.MVPAppd2.UI;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mobile.appd2.MVPAppd2.Fragment.FacebookLoginFragment;
import com.mobile.appd2.MVPAppd2.R;

import static com.facebook.FacebookSdk.*;

/**
 * Created by david on 9/12/15.
 */


public class FacebookLoginActivity extends AppCompatActivity implements FacebookLoginFragment.OnFragmentInteractionListener {

    private static final long SPLASH_TIME_OUT = 200;
    private FacebookLoginFragment mainFragment;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            mainFragment = new FacebookLoginFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, mainFragment).commit();

        } else {
            // Or set the fragment from restored state info
            mainFragment = (FacebookLoginFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }

    }

    public void gotoBudget(){

        mainFragment.getProfile();
        Intent budgetIntent = new Intent().setClass(
                FacebookLoginActivity.this, BudgetActivity.class);

        SharedPreferences sharedpreferences = this.getSharedPreferences(
                "com.mobile.appd2.MVPAppd2", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString("USER_NAME", userName);
        editor.putString("USER_ID", userId);
//        budgetIntent.putExtra("FACEBOOK_ID", userId);
//        budgetIntent.putExtra("FACEBOOK_NAME", userName);
        startActivity(budgetIntent);
        finish();
    }

    public void updateWithToken(AccessToken currentAccessToken) {

        if (currentAccessToken != null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                   gotoBudget();
                }
            }, SPLASH_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                }
            }, SPLASH_TIME_OUT);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
