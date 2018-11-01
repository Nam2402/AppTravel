package com.example.nam.travel.presenters.places.newLocation;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.newLocation.NewLocationResponse;
import com.example.nam.travel.views.newLocation.INewLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/1/2018.
 */

public class NewLocationPresenter implements INewLocationPresenter {
    private INewLocation iNewLocation;

    public NewLocationPresenter(INewLocation iNewLocation) {
        this.iNewLocation = iNewLocation;
    }

    @Override
    public void getNewLocation() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewLocationResponse> call = apiService.getInfoNewLocation();
        call.enqueue(new Callback<NewLocationResponse>() {
            @Override
            public void onResponse(Call<NewLocationResponse> call, Response<NewLocationResponse> response) {
                if (response.code() >= 300) {
                    iNewLocation.getNewLocationFailure();
                } else if (response.code() >= 200) {
                    NewLocationResponse newLocationResponse = response.body();
                    if (newLocationResponse.getResultCode() == 200) {
                        iNewLocation.getNewLocationSuccess(newLocationResponse.getData());
                    }
                } else {

                    iNewLocation.getNewLocationFailure();                }
            }

            @Override
            public void onFailure(Call<NewLocationResponse> call, Throwable t) {
                iNewLocation.getNewLocationFailure();            }
        });

    }
}
