package com.example.nam.travel.presenters.recommendLocation;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/4/2018.
 */

public class RecommendLocationPresenter implements  IRecommendLocationPresenter {
    private IBaseLocation iRecommendLocation;

    public RecommendLocationPresenter(IBaseLocation iRecommendLocation) {
        this.iRecommendLocation = iRecommendLocation;
    }

    @Override
    public void getRecommendLocation() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseLocationResponse> call = apiService.getInfoRecommendLocation(MainActivity.token);
        call.enqueue(new Callback<BaseLocationResponse>() {
            @Override
            public void onResponse(Call<BaseLocationResponse> call, Response<BaseLocationResponse> response) {
                if (response.code() >= 300) {
                    iRecommendLocation.getBaseLocationFailure();
                } else if (response.code() >= 200) {
                    BaseLocationResponse recommendLocationResponse = response.body();
                    if (recommendLocationResponse.getResultCode() == 200) {
                        iRecommendLocation.getBaseLocationSuccess(recommendLocationResponse.getData());
                    }
                } else {

                    iRecommendLocation.getBaseLocationFailure();                }
            }

            @Override
            public void onFailure(Call<BaseLocationResponse> call, Throwable t) {
                iRecommendLocation.getBaseLocationFailure();            }
        });

    }
}
