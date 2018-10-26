package com.example.nam.travel.presenters.locationOfCategory;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.locationOfPlaceCategory.LocationResponse;
import com.example.nam.travel.views.place.IPlaceActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 10/23/2018.
 */

public class LocationPresenter implements ILocationPresenter {
    private IPlaceActivity iPlaceActivity;

    public LocationPresenter(IPlaceActivity iPlaceActivity) {
        this.iPlaceActivity = iPlaceActivity;
    }

    @Override
    public void getLocation() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LocationResponse> call = apiService.getInfoLocation();
        call.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                if (response.code() >= 300) {
                    iPlaceActivity.getLocationFailure();
                } else if (response.code() >= 200) {
                    LocationResponse locationResponse = response.body();
                    if (locationResponse.getResultCode() == 200) {
                        iPlaceActivity.getLocationSuccess(locationResponse.getData());
                    }
                } else {

                    iPlaceActivity.getLocationFailure();
                }
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                iPlaceActivity.getLocationFailure();
            }
        });

    }
}
