package com.example.nam.travel.api;

import com.example.nam.travel.models.location.DetailLocationResponse;
import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;


import com.example.nam.travel.models.login.LoginResponse;
import com.example.nam.travel.models.review.ReviewPaginationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> getToken(@Field("username") String username,
                                 @Field("password") String password);

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





}
