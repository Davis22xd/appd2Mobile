package com.mobile.appd2.MVPAppd2.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mobile.appd2.MVPAppd2.Fragment.BudgetFragment;
import com.mobile.appd2.MVPAppd2.R;

import java.util.UUID;

public class BudgetActivity extends BaseActivity implements  BudgetFragment.OnFragmentInteractionListener {

    private FragmentManager fm;
    private BudgetFragment budgetFragment;
    private static final String BUDGET_FRAGMENT_TAG = "BUDGET_FRAGMENT_TAG";


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_budget);
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
        if (fm.findFragmentByTag(BUDGET_FRAGMENT_TAG) == null) {
            budgetFragment = new BudgetFragment().newInstance();
            fm.beginTransaction().add(R.id.containerFragmentBudget, budgetFragment, BUDGET_FRAGMENT_TAG).commit();
        }

        setNavigationHeader();    // call setNavigationHeader Method.
        setUserProfile();  // call setUserProfile Method.
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    public void gotoAvailability(UUID uniqueKey, int budget) {

        Intent availabilityIntent = new Intent().setClass(
                BudgetActivity.this, AvailabilityActivity.class);
        String uui = uniqueKey.toString();
        availabilityIntent.putExtra("VoKey",uui );
        availabilityIntent.putExtra("BUDGET", budget);
        startActivity(availabilityIntent);
        finish();
    }

    public void gotoLogin() {

        Intent loginIntent = new Intent().setClass(
                BudgetActivity.this, FacebookLoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}