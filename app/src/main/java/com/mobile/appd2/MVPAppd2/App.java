package com.mobile.appd2.MVPAppd2;

import android.app.Application;
import android.content.Context;

/**
 * Created by david on 14/2/16.
 */
public class App extends Application{

    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getStaticContext(){
        return App.context;
    }
}
