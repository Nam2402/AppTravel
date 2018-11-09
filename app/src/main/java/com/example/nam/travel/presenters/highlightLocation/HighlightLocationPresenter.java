package com.example.nam.travel.presenters.highlightLocation;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/5/2018.
 */

public class HighlightLocationPresenter implements IHighlightLocationPresenter {
    private IBaseLocation iNewLocation;

    public HighlightLocationPresenter(IBaseLocation iNewLocation) {
        this.iNewLocation = iNewLocation;
    }

    @Override
    public void getHighlightLocation() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseLocationResponse> call = apiService.getInfoHighlightLocation();
        call.enqueue(new Callback<BaseLocationResponse>() {
            @Override
            public void onResponse(Call<BaseLocationResponse> call, Response<BaseLocationResponse> response) {
                if (response.code() >= 300) {
                    iNewLocation.getBaseLocationFailure();
                } else if (response.code() >= 200) {
                    BaseLocationResponse newLocationResponse = response.body();
                    if (newLocationResponse.getResultCode() == 200) {
                        iNewLocation.getBaseLocationSuccess(newLocationResponse.getData());
                    }
                } else {

                    iNewLocation.getBaseLocationFailure();                }
            }

            @Override
            public void onFailure(Call<BaseLocationResponse> call, Throwable t) {
                iNewLocation.getBaseLocationFailure();            }
        });

    }
}
