package com.example.nam.travel.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiImageInterface {
    @GET()
    Call<ResponseBody> getImageDetails(@Url String url);
}
