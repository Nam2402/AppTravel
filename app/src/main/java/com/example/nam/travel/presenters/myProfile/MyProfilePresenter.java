package com.example.nam.travel.presenters.myProfile;

import android.util.Log;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.myProfile.MyProfileResponse;
import com.example.nam.travel.views.myProfile.IMyProfileActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/10/2018.
 */

public class MyProfilePresenter implements IMyProfilePresenter {
    public static String TAG = "MY PROFILE PRESENTER";
    private IMyProfileActivity iMyProfileActivity;

    public MyProfilePresenter(IMyProfileActivity iMyProfileActivity) {
        this.iMyProfileActivity = iMyProfileActivity;
    }

    @Override
    public void getMyProfile(String token) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MyProfileResponse> call = apiService.getMyProfile(token);
        call.enqueue(new Callback<MyProfileResponse>() {
            @Override
            public void onResponse(Call<MyProfileResponse> call, Response<MyProfileResponse> response) {
                Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iMyProfileActivity.getMyProfileFailure();
                } else if (response.code() == 200) {
                    iMyProfileActivity.getMyProfileSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<MyProfileResponse> call, Throwable t) {
                Log.d(TAG, "failure");
                iMyProfileActivity.getMyProfileFailure();
            }
        });

    }
}
