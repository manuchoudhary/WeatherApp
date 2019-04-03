package com.io.manish.weatherapp.main_activity;

import android.util.Log;

import com.io.manish.weatherapp.model.PlaceList;
import com.io.manish.weatherapp.my_interface.GetPlaceDataService;
import com.io.manish.weatherapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPlaceIntractorImpl implements MainContract.GetPlaceIntractor {

    private static final String APP_KEY = "dfacf274e1019ac2a973c67668672d41";
    private static final int COUNT = 10;

    @Override
    public void getPlaceArrayList(final OnFinishedListener onFinishedListener, double lat, double lon) {


        /** Create handle for the RetrofitInstance interface*/
        GetPlaceDataService service = RetrofitInstance.getRetrofitInstance().create(GetPlaceDataService.class);

        /** Call the method with parameter in the interface to get the place data*/
        Call<PlaceList> call = service.getPlaceData(lat, lon, COUNT, APP_KEY);

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<PlaceList>() {
            @Override
            public void onResponse(Call<PlaceList> call, Response<PlaceList> response) {
                onFinishedListener.onFinished(response.body().getPlaceArrayList());

            }

            @Override
            public void onFailure(Call<PlaceList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
