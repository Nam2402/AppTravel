package com.example.nam.travel.api;

import com.example.nam.travel.models.locationOfPlaceCategory.LocationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/app/place-type/1")
    Call<TypeResponse> getNameCategory();

    @GET("/location-profile-by-category/4")
    Call<LocationResponse> getInfoLocation();



}
