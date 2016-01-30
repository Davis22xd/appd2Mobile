package com.mobile.appd2.MVPAppd2.UI;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
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
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.mobile.appd2.MVPAppd2.Fragment.AvailabilityFragment;
import com.mobile.appd2.MVPAppd2.Fragment.DatePickerFragment;
import com.mobile.appd2.MVPAppd2.Fragment.TimePickerFragment;
import com.mobile.appd2.MVPAppd2.R;

import java.util.Calendar;

public class AvailabilityActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AvailabilityFragment.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private FragmentManager fm;
    private DialogFragment newFragment;
//    private  Calendar calendar;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    private String user_name;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_id;
    private TextView userName;
    private ProfilePictureView userPicture;
    public static LoginManager loginManager;
    private AvailabilityFragment availabilityFragment;
    private static final String AVAILABILITY_FRAGMENT_TAG = "AVAILABILITY_FRAGMENT_TAG";
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreferences = this.getSharedPreferences(
                "com.mobile.appd2.MVPAppd2", Context.MODE_PRIVATE);

        String userName = "com.mobile.appd2.MVPAppd2.FACEBOOK_NAME";
        user_name =sharedpreferences.getString(userName, new String());
        String userId = "com.mobile.appd2.MVPAppd2.FACEBOOK_ID";
        user_id =sharedpreferences.getString(userId, new String());

        setContentView(R.layout.activity_availability);
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
        if (fm.findFragmentByTag(AVAILABILITY_FRAGMENT_TAG) == null) {
            availabilityFragment = new AvailabilityFragment().newInstance();
            fm.beginTransaction().add(R.id.containerFragmentAvailability, availabilityFragment, AVAILABILITY_FRAGMENT_TAG).commit();
        }

        setNavigationHeader();    // call setNavigationHeader Method.
        setUserProfile();  // call setUserProfile Method.
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
        getMenuInflater().inflate(R.menu.availability, menu);
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

    public void showDatePickerDialog(View v) {
        newFragment = new DatePickerFragment();
        FragmentManager fragManager = getSupportFragmentManager();
        newFragment.show(fragManager, "datePicker");
    }

    public void showTimePickerDialog(View v) {
        newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        availabilityFragment.showDate(year, monthOfYear, dayOfMonth);
        availabilityFragment.saveDate(year, monthOfYear, dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        availabilityFragment.showTime(hourOfDay, minute);
        availabilityFragment.savetTime(hourOfDay,minute);
    }

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

    public void gotoLogin() {

        Intent loginIntent = new Intent().setClass(
                AvailabilityActivity.this, FacebookLoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    public void gotoFeelings() {

        Intent environmentIntent = new Intent().setClass(
                AvailabilityActivity.this, EnvironmentActivity.class);
        startActivity(environmentIntent);
        finish();
    }

}
