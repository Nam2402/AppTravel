package com.example.nam.travel.presenters.detailLocation;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.api.ApiResponse;
import com.example.nam.travel.models.location.DetailLocationResponse;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;
import com.example.nam.travel.presenters.highlightLocation.IHighlightLocationPresenter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;
import com.example.nam.travel.views.location.detailLocation.IDetailLocationActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/5/2018.
 */

public class DetailLocationPresenter implements IDetailLocationPresenter {

    private IDetailLocationActivity iDetailLocation;

    public DetailLocationPresenter(IDetailLocationActivity iDetailLocation) {
        this.iDetailLocation = iDetailLocation;
    }

    @Override
    public void favoriteLocation(Long idLocation) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.favoriteLocation(idLocation, MainActivity.token);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code() >= 300) {
                    iDetailLocation.favoriteLocationFailure();
                } else if (response.code() >= 200) {
                    ApiResponse apiResponse = response.body();
                    if (apiResponse.getResult_code() == 200) {
                        iDetailLocation.favoriteLocationSuccess();
                    } else {
                        iDetailLocation.favoriteLocationFailure();
                    }
                } else {
                    iDetailLocation.favoriteLocationFailure();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iDetailLocation.favoriteLocationFailure();
            }
        });

    }

    @Override
    public void getDetailLocation(Long idLocation) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailLocationResponse> call = apiService.getInfoDetailLocation(idLocation, MainActivity.token);
        call.enqueue(new Callback<DetailLocationResponse>() {
            @Override
            public void onResponse(Call<DetailLocationResponse> call, Response<DetailLocationResponse> response) {
                if (response.code() >= 300) {
                    iDetailLocation.getDetailLocationFailure();
                } else if (response.code() >= 200) {
                    DetailLocationResponse detailLocationResponse = response.body();
                    if (detailLocationResponse.getResult_code() == 200) {
                        iDetailLocation.getDetailLocationSuccess(detailLocationResponse.getData());
                    }
                } else {

                    iDetailLocation.getDetailLocationFailure();                }
            }
            @Override
            public void onFailure(Call<DetailLocationResponse> call, Throwable t) {
                iDetailLocation.getDetailLocationFailure();            }
        });

    }
}