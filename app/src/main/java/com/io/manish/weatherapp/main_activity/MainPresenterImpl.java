package com.io.manish.weatherapp.main_activity;

import com.io.manish.weatherapp.model.Place;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetPlaceIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetPlaceIntractor getPlaceIntractor;
    private double lat, lon;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetPlaceIntractor getPlaceIntractor,
                             double lat, double lon) {
        this.mainView = mainView;
        this.getPlaceIntractor = getPlaceIntractor;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getPlaceIntractor.getPlaceArrayList(this, lat, lon);

    }

    @Override
    public void requestDataFromServer() {
        getPlaceIntractor.getPlaceArrayList(this, lat, lon);
    }


    @Override
    public void onFinished(ArrayList<Place> placeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(placeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
