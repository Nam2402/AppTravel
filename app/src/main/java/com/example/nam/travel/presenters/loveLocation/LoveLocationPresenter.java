package com.example.nam.travel.presenters.loveLocation;

import android.util.Log;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocationResponse;
import com.example.nam.travel.models.myProfile.MyProfileResponse;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/13/2018.
 */

public class LoveLocationPresenter implements ILoveLocationPresenter {
    public static String TAG = "LOVE LOCATION PRESENTER";
    private IBaseLocation iBaseLocation;

    public LoveLocationPresenter(IBaseLocation iBaseLocation) {
        this.iBaseLocation = iBaseLocation;
    }

    @Override
    public void getLoveLocation(String token) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseLocationResponse> call = apiService.getLoveLocation(token);
        call.enqueue(new Callback<BaseLocationResponse>() {
            @Override
            public void onResponse(Call<BaseLocationResponse> call, Response<BaseLocationResponse> response) {
                Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iBaseLocation.getBaseLocationFailure();
                } else if (response.code() == 200) {
                    iBaseLocation.getBaseLocationSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<BaseLocationResponse> call, Throwable t) {
                Log.d(TAG, "failure");
                iBaseLocation.getBaseLocationFailure();
            }
        });

    }
}
