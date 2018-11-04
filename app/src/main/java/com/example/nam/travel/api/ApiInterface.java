package com.example.nam.travel.api;

import com.example.nam.travel.models.newLocation.NewLocationResponse;
import com.example.nam.travel.models.recommendLocation.RecommendLocationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/app/place-type/3")
    Call<TypeResponse> getNameCategory();

    @GET("/top-10-new-locations")
    Call<NewLocationResponse> getInfoNewLocation();

    @GET("/locations/recommends/1")
    Call<RecommendLocationResponse> getInfoRecommendLocation();

//    @GET("/location-profile-by-category/4")
//    Call<LocationResponse> getInfoLocation();



}
