package com.example.nam.travel.presenters.myProfile;

import android.util.Log;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.myProfile.EditProfileResponse;
import com.example.nam.travel.views.myProfile.IEditProfileActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/20/2018.
 */

public class EditProfilePresenter implements IEditProfilePresenter {
    private IEditProfileActivity iEditProfileActivity;

    public EditProfilePresenter(IEditProfileActivity iEditProfileActivity) {
        this.iEditProfileActivity = iEditProfileActivity;
    }
    @Override
    public void editProfile(RequestBody json, String token) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<EditProfileResponse> call = apiService.editProfileUser(json, token);
        call.enqueue(new Callback<EditProfileResponse>() {
            @Override
            public void onResponse(Call<EditProfileResponse> call, Response<EditProfileResponse> response) {
                if (response.code() >= 300) {
                    iEditProfileActivity.editProfileFailure_ServerError();
                } else if (response.code() == 200) {
                    if (response.body().getResultCode() == 422) {
                        iEditProfileActivity.editProfileFailure_WrongData();
                    }
                    if (response.body().getResultCode() == 500) {
                        iEditProfileActivity.editProfileFailure_ServerError();
                    }
                    if (response.body().getResultCode() == 200) {
                        //Save token
                        iEditProfileActivity.editProfileSuccess();
                    }
                }
            }


            @Override
            public void onFailure(Call<EditProfileResponse> call, Throwable t) {
                iEditProfileActivity.editProfileFailure_ServerError();
            }
        });
    }

}
