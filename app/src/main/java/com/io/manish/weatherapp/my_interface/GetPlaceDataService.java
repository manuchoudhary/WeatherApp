package com.io.manish.weatherapp.my_interface;

import com.io.manish.weatherapp.model.PlaceList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPlaceDataService {

    @GET("find?")
    Call<PlaceList> getPlaceData(@Query("lat") double lat,
                                 @Query("lon") double lon,
                                 @Query("cnt") int cnt,
                                 @Query("appid") String appId);

}