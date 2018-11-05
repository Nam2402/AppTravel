package com.example.nam.travel.presenters.recommendLocation;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.recommendLocation.RecommendLocationResponse;
import com.example.nam.travel.views.recommendLocation.IRecommendLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/4/2018.
 */

public class RecommendLocationPresenter implements  IRecommendLocationPresenter {
    private IRecommendLocation iRecommendLocation;

    public RecommendLocationPresenter(IRecommendLocation iRecommendLocation) {
        this.iRecommendLocation = iRecommendLocation;
    }

    @Override
    public void getRecommendLocation() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<RecommendLocationResponse> call = apiService.getInfoRecommendLocation();
        call.enqueue(new Callback<RecommendLocationResponse>() {
            @Override
            public void onResponse(Call<RecommendLocationResponse> call, Response<RecommendLocationResponse> response) {
                if (response.code() >= 300) {
                    iRecommendLocation.getRecommendLocationFailure();
                } else if (response.code() >= 200) {
                    RecommendLocationResponse recommendLocationResponse = response.body();
                    if (recommendLocationResponse.getResultCode() == 200) {
                        iRecommendLocation.getRecommendLocationSuccess(recommendLocationResponse.getData());
                    }
                } else {

                    iRecommendLocation.getRecommendLocationFailure();                }
            }

            @Override
            public void onFailure(Call<RecommendLocationResponse> call, Throwable t) {
                iRecommendLocation.getRecommendLocationFailure();            }
        });

    }
}
