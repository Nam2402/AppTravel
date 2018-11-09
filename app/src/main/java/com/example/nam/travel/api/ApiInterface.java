package com.example.nam.travel.api;

import com.example.nam.travel.models.location.DetailLocationResponse;
import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;


import com.example.nam.travel.models.review.ReviewPaginationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/app/place-type/{id_type}")
    Call<TypeResponse> getNameCategory(@Path("id_type") Long id_type);

    @GET("/top-10-new-locations")
    Call<BaseLocationResponse> getInfoNewLocation();

    @GET("/locations/recommends/6")
    Call<BaseLocationResponse> getInfoRecommendLocation();

    @GET("/app/location/top-10-highlight")
    Call<BaseLocationResponse> getInfoHighlightLocation();

    @GET("app/location/{idLocation}")
    Call<DetailLocationResponse> getInfoDetailLocation(@Path("idLocation") Long idLocation);

    @GET("/app/review/{idLocation}/{crrPage}")
    Call<ReviewPaginationResponse> getReviewPagination(@Path("idLocation") Long idLocation, @Path("crrPage") int crrPage);

//    @GET("/location-profile-by-category/4")
//    Call<LocationResponse> getInfoLocation();



}
