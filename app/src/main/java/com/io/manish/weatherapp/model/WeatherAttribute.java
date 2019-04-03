package com.io.manish.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class WeatherAttribute {

    @SerializedName("temp")
    private String temprature;
    @SerializedName("humidity")
    private String humidity;

    public String getTemprature() {
        return temprature;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
