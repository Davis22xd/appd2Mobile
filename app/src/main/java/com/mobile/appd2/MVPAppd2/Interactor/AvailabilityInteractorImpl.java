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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public AvailabilityInteractorImpl(AvailabilityStateView availabilityView, AvailabilityListener availabilityListener) {
        this.availabilityView = availabilityView;
        this.availabilityListener = availabilityListener;
    }

    @Override
    public void saveAvailability(int year,int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
        availability = Calendar.getInstance();
        availability.set(Calendar.YEAR, year);
        availability.set(Calendar.MONTH, monthOfYear);
        availability.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        availability.set(Calendar.HOUR_OF_DAY, hourOfDay);
        availability.set(Calendar.MINUTE, minute);
        setAvailability(availability);

        boolean validation = validateDate(availability);

        if(validation){
//            Gson gson = new Gson();
//            String stringAvailability = gson.toJson(getAvailability());
            availabilityView.goNextStep(date,availability.get(Calendar.HOUR_OF_DAY),availability.get(Calendar.MINUTE));
//            editor.putString("Availability", String.valueOf(stringAvailability));
//            System.out.println("la clave es: " + availability);
        }

        else{
            availabilityListener.onMessageError("Seleccione una fecha correcta");
        }




    }

    public boolean validateDate(Calendar availability){

        boolean validation;
        Calendar calendarToday = Calendar.getInstance();

        if(availability.after(calendarToday)){
            int year = availability.get(Calendar.YEAR);
            int month = availability.get(Calendar.MONTH);
            int day = availability.get(Calendar.DAY_OF_MONTH);

            String formatedDate = year + "/" + month + "/" + day;
            setDate(formatedDate);

            validation= true;
        }

        else{
            validation = false;
        }
        return validation;

    }
}
