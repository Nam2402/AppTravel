package com.example.nam.travel.api;

import com.example.nam.travel.models.categoryPlace.CategoryResponse;
import com.example.nam.travel.models.location.DetailLocationResponse;
import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;


import com.example.nam.travel.models.login.LoginResponse;
import com.example.nam.travel.models.myProfile.MyProfileResponse;
import com.example.nam.travel.models.review.ReviewPaginationResponse;
import com.example.nam.travel.models.typePlace.TypeResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> getToken(@Field("username") String username,
                                 @Field("password") String password);

    @GET("api/user-profile")
    Call<MyProfileResponse> getMyProfile(@Header("Authorization") String token);

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

    /*Get love location of user*/
    @GET("api/app/locations/user-like")
    Call<BaseLocationResponse> getLoveLocation(@Header("Authorization") String token);

    @GET("/app/place-category/{idCat}")
    Call<CategoryResponse> getCategoryInfo(@Path("idCat") Long idCat);





}
