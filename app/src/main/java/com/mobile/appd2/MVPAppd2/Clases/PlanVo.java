package com.mobile.appd2.MVPAppd2.Clases;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 16/2/16.
 */
public class PlanVo {



    @SerializedName("token")

    String token;

    @SerializedName("budget")

    int budget;

    @SerializedName("date")

    String date;

    @SerializedName("hour")

    int hour;

    @SerializedName("minute")

    int minute;

    @SerializedName("feeling")

    String feeling;


    public PlanVo(String token, int budget, String date, int hour, int minute, String feeling) {

        this.token = token;

        this.budget = budget;

        this.date = date;

        this.hour = hour;

        this.minute = minute;

        this.feeling = feeling;

    }


    @Override
    public String toString() {
        return  "token :" + token + "\n budget: "+ budget +
                "\n date: " + date + "\n time: " + hour +
                ":" + minute + "\n feeling: " + feeling ;
    }
}
