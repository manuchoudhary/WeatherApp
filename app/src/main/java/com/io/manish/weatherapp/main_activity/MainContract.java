package com.io.manish.weatherapp.main_activity;

import com.io.manish.weatherapp.model.Place;

import java.util.ArrayList;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetPlaceInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Place> placeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetPlaceIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Place> placeArrayList);
            void onFailure(Throwable t);
        }

        void getPlaceArrayList(OnFinishedListener onFinishedListener, double lat, double lon);
    }
}
