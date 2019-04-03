package com.io.manish.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String placeName;
    @SerializedName("main")
    private WeatherAttribute main ;

    public Place(String id, String placeName, WeatherAttribute main) {
        this.id = id;
        this.placeName = placeName;
        this.main = main;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return placeName;
    }

    public void setName(String placeName) {
        this.placeName = placeName;
    }

    public WeatherAttribute getWeatherAttribute() {
        return main;
    }

    public void setWeatherAttribute(WeatherAttribute main) {
        this.main = main;
    }
}