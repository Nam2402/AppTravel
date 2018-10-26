package com.example.nam.travel.api;

import com.example.nam.travel.models.categoryPlace.CategoryPlacesResponse;
import com.example.nam.travel.models.locationOfPlaceCategory.LocationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/place-type/5/place-category")
    Call<CategoryPlacesResponse> getNameCategory();

    @GET("/location-profile-by-category/4")
    Call<LocationResponse> getInfoLocation();



}
