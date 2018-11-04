package com.example.nam.travel.api;

import com.example.nam.travel.models.newLocation.NewLocationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/app/place-type/3")
    Call<TypeResponse> getNameCategory();

    @GET("/location-profile-by-category/42")
    Call<NewLocationResponse> getInfoNewLocation();

//    @GET("/location-profile-by-category/4")
//    Call<LocationResponse> getInfoLocation();



}
