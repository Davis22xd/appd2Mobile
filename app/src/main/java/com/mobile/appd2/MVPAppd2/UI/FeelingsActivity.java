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
import android.support.v7.widget.GridLayoutManager;
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
import com.mobile.appd2.MVPAppd2.Adapter.RecyclerViewAdapter;
import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.Fragment.FeelingsFragment;
import com.mobile.appd2.MVPAppd2.Fragment.DatePickerFragment;
import com.mobile.appd2.MVPAppd2.Fragment.TimePickerFragment;
import com.mobile.appd2.MVPAppd2.R;

import java.util.List;

public class FeelingsActivity extends BaseActivity implements FeelingsFragment.OnFragmentInteractionListener {

    private FragmentManager fm;
    private DialogFragment newFragment;
    private FeelingsFragment feelingsFragment;
    private static final String FEELINGS_FRAGMENT_TAG = "FEELINGS_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feelings);
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
    if (fm.findFragmentByTag(FEELINGS_FRAGMENT_TAG) == null) {
        feelingsFragment = new FeelingsFragment().newInstance();
        fm.beginTransaction().add(R.id.containerFragmentFeelings, feelingsFragment, FEELINGS_FRAGMENT_TAG).commit();
    }

    setNavigationHeader();    // call setNavigationHeader Method.
    setUserProfile();  // call setUserProfile Method.
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.feelings, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void gotoLogin() {

        Intent loginIntent = new Intent().setClass(
                FeelingsActivity.this, FacebookLoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    public void gotoEnviroment() {

       /* Intent feelingsIntent = new Intent().setClass(
                BudgetActivity.this, feelingsActivity.class);
        startActivity(feelingsIntent);
        finish();*/
    }

    public GridLayoutManager createNewGrid(){

        GridLayoutManager layout =new GridLayoutManager(this, 2);
        return layout;
    }

//    public RecyclerViewAdapter createAdapter(List<Feeling> rowListItem){
//
////        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, rowListItem,);
////        return rcAdapter;
//    }

}
