package com.example.nam.travel.presenters.places;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.views.place.IPlaceActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 10/17/2018.
 */

public class PlacePresenter implements IPlacePresenter {
    private IPlaceActivity iPlaceActivity;

    public PlacePresenter(IPlaceActivity iPlaceActivity) {
        this.iPlaceActivity = iPlaceActivity;
    }

    @Override
    public void getPlaceCategory() {
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<CategoryPlacesResponse> call = apiService.getNameCategory();
//        call.enqueue(new Callback<CategoryPlacesResponse>() {
//            @Override
//            public void onResponse(Call<CategoryPlacesResponse> call, Response<CategoryPlacesResponse> response) {
//                if (response.code() >= 300) {
//                    iPlaceActivity.getPlaceFailure();
//                } else if (response.code() >= 200) {
//                    CategoryPlacesResponse categoryPlacesResponse = response.body();
//                    if (categoryPlacesResponse.getResultCode() == 200) {
//                        iPlaceActivity.getPlaceSuccess(categoryPlacesResponse.getData());
//                    }
//                } else {
//
//                    iPlaceActivity.getPlaceFailure();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CategoryPlacesResponse> call, Throwable t) {
//                iPlaceActivity.getPlaceFailure();
//            }
//        });

    }
}
