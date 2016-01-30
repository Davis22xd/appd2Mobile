package com.mobile.appd2.MVPAppd2.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by david on 1/12/15.
 */
public class SplashActivity extends AppCompatActivity {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (isFirstTime()) {
                    // Start the next activity
                    Intent wizardIntent = new Intent().setClass(
                            SplashActivity.this, WizardActivity.class);
                    startActivity(wizardIntent);

                    // Close the activity so the user won't able to go back this
                    // activity pressing Back button
                    finish();
                }
                else {
                    // Start the next activity


                    Intent loginIntent = new Intent().setClass(
                            SplashActivity.this, FacebookLoginActivity.class);
                    startActivity(loginIntent);

                    // Close the activity so the user won't able to go back this
                    // activity pressing Back button
                    finish();
                }
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }

}

