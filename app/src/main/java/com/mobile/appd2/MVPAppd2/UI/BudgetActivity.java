package com.mobile.appd2.MVPAppd2.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mobile.appd2.MVPAppd2.Fragment.BudgetFragment;
import com.mobile.appd2.MVPAppd2.Fragment.LoginFragment;
import com.mobile.appd2.MVPAppd2.R;

public class BudgetActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BudgetFragment.OnFragmentInteractionListener {

    private FragmentManager fm;
    private BudgetFragment budgetFragment;
    private static final String BUDGET_FRAGMENT_TAG = "BUDGET_FRAGMENT_TAG";
    private Profile profile;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_name;
    private String user_id;
    private TextView userName;
    private ProfilePictureView userPicture;
    public static LoginManager loginManager;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        user_name =bundle.getString("FACEBOOK_NAME");
        user_id =bundle.getString("FACEBOOK_ID");

        SharedPreferences sharedpreferences = this.getSharedPreferences(
                "com.mobile.appd2.MVPAppd2", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString("USER_NAME", getUser_name());
        editor.putString("USER_ID", getUser_id());

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
//            budgetFragment = new BudgetFragment().newInstance("a", "b");
            budgetFragment = new BudgetFragment().newInstance();
            fm.beginTransaction().add(R.id.containerFragmentBudget, budgetFragment, BUDGET_FRAGMENT_TAG).commit();
        }

        setNavigationHeader();    // call setNavigationHeader Method.
        setUserProfile();  // call setUserProfile Method.
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_plan) {
            // Handle the camera action
        } else if (id == R.id.nav_discover) {

        } else if (id == R.id.nav_activity) {

        } else if (id == R.id.nav_invite) {

        } else if (id == R.id.nav_notifications) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_logout) {
            loginManager.getInstance().logOut();
            gotoLogin();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*
        Set Navigation header by using Layout Inflater.
     */

    public void setNavigationHeader() {

        NavigationView navigation_view = (NavigationView) findViewById(R.id.nav_view);

        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_login, null);
        navigation_view.addHeaderView(header);

        userName = (TextView) header.findViewById(R.id.user_name);
        userPicture = (ProfilePictureView) header.findViewById(R.id.profilePicture);
    }

    /*
       Set User Profile Information in Navigation Bar.
     */

    public void setUserName(String name) {
        userName.setText(name);
    }

    public void setUserId(String id) {
        userPicture.setProfileId(id);
    }


    public void setUserProfile() {

        try {
            setUserName(user_name);
            setUserId(user_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoAvailability() {

        Intent availabilityIntent = new Intent().setClass(
                BudgetActivity.this, AvailabilityActivity.class);
        startActivity(availabilityIntent);
        finish();
    }

    public void gotoLogin() {

        Intent loginIntent = new Intent().setClass(
                BudgetActivity.this, FacebookLoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

}