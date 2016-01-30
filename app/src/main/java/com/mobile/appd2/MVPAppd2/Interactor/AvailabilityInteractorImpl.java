package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mobile.appd2.MVPAppd2.Listener.AvailabilityListener;
import com.mobile.appd2.MVPAppd2.View.AvailabilityStateView;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by david on 29/11/15.
 */
public class AvailabilityInteractorImpl implements AvailabiltyInteractor {

    private  AvailabilityListener availabilityListener;
    private  SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private AvailabilityStateView availabilityView;

    public Calendar getAvailability() {
        return availability;
    }

    public void setAvailability(Calendar availability) {
        this.availability = availability;
    }

    private Calendar availability = new Calendar() {

        @Override
        public void add(int field, int value) {

        }

        @Override
        protected void computeFields() {

        }

        @Override
        protected void computeTime() {

        }

        @Override
        public int getGreatestMinimum(int field) {
            return 0;
        }

        @Override
        public int getLeastMaximum(int field) {
            return 0;
        }

        @Override
        public int getMaximum(int field) {
            return 0;
        }

        @Override
        public int getMinimum(int field) {
            return 0;
        }

        @Override
        public void roll(int field, boolean increment) {

        }
    };

    public AvailabilityInteractorImpl(AvailabilityStateView availabilityView, AvailabilityListener availabilityListener) {
        this.availabilityView = availabilityView;
        this.availabilityListener = availabilityListener;
    }

    @Override
    public boolean saveAvailability(int year,int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
        availability = Calendar.getInstance();
        availability.set(Calendar.YEAR, year);
        availability.set(Calendar.MONTH, monthOfYear);
        availability.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        availability.set(Calendar.HOUR_OF_DAY, hourOfDay);
        availability.set(Calendar.MINUTE, minute);
        setAvailability(availability);

        boolean validation = validateDate(availability);

        if(validation==true){
            Gson gson = new Gson();
            String stringAvailability = gson.toJson(getAvailability());

            editor.putString("Availability", String.valueOf(stringAvailability));
            System.out.println("la clave es: " + availability);
            return true;
        }

        else{
            availabilityListener.onMessageError("Seleccione una fecha correcta");
            return false;
        }


    }

    @Override
    public void getPreference(SharedPreferences preference) {
        sharedpreferences = preference;
        editor = sharedpreferences.edit();
    }

    public boolean validateDate(Calendar availability){

        int year = availability.get(Calendar.YEAR);
        int month = availability.get(Calendar.MONTH);
        int day = availability.get(Calendar.DAY_OF_MONTH);
        boolean validation = false;

        Calendar calendarToday = Calendar.getInstance();
        if(availability.after(calendarToday)){
            validation= true;
        }

        else{
            validation = false;
        }
        return validation;

    }
}
