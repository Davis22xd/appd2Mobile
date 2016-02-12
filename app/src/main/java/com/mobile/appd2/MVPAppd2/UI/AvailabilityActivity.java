package com.mobile.appd2.MVPAppd2.UI;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.mobile.appd2.MVPAppd2.Fragment.AvailabilityFragment;
import com.mobile.appd2.MVPAppd2.Fragment.DatePickerFragment;
import com.mobile.appd2.MVPAppd2.Fragment.TimePickerFragment;
import com.mobile.appd2.MVPAppd2.R;


public class AvailabilityActivity extends BaseActivity
        implements AvailabilityFragment.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private FragmentManager fm;
    private DialogFragment newFragment;
    private AvailabilityFragment availabilityFragment;
    private static final String AVAILABILITY_FRAGMENT_TAG = "AVAILABILITY_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.availability, menu);
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

     /*
       Set User Profile Information in Navigation Bar.
     */

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
