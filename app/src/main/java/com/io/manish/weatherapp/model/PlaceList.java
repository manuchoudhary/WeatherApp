package com.io.manish.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlaceList {

    @SerializedName("list")
    private ArrayList<Place> placeList;

    public ArrayList<Place> getPlaceArrayList() {
        return placeList;
    }

    public void setPlaceArrayList(ArrayList<Place> placeArrayList) {
        this.placeList = placeArrayList;
    }
}