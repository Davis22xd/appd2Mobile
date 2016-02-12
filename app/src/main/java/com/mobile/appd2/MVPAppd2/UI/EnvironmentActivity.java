package com.mobile.appd2.MVPAppd2.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.mobile.appd2.MVPAppd2.Fragment.EnvironmentFragment;
import com.mobile.appd2.MVPAppd2.R;

public class EnvironmentActivity extends BaseActivity implements EnvironmentFragment.OnFragmentInteractionListener {

    private FragmentManager fm;
    private EnvironmentFragment environmentFragment;
    private static final String ENVIRONMENT_FRAGMENT_TAG = "ENVIRONMENT_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_environment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm = this.getSupportFragmentManager();
        if (fm.findFragmentByTag(ENVIRONMENT_FRAGMENT_TAG) == null) {
            environmentFragment = new EnvironmentFragment().newInstance();
            fm.beginTransaction().add(R.id.containerFragmentEnvironment, environmentFragment, ENVIRONMENT_FRAGMENT_TAG).commit();
        }

        setNavigationHeader();    // call setNavigationHeader Method.
        setUserProfile();  // call setUserProfile Method.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.environment, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void gotoLogin() {

        Intent loginIntent = new Intent().setClass(
                EnvironmentActivity.this, FacebookLoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    public void gotoFeelings() {

        Intent feelingsIntent = new Intent().setClass(
                EnvironmentActivity.this, FeelingsActivity.class);
        startActivity(feelingsIntent);
        finish();
    }

}
