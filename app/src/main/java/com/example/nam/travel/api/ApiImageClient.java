package com.example.nam.travel.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nam on 10/17/2018.
 */

public class ApiImageClient {
    public static final String BASE_URL = "https://travellingrecommend.herokuapp.com/image";
    public static final String URL_IMAGE_DEFAULT = "https://travellingrecommend.herokuapp.com/image/default.jpg";
    private static Retrofit retrofit = null;

    public static Retrofit getImageClient(){
        if(retrofit ==null){
            retrofit =  new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
