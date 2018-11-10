package com.example.nam.travel.presenters.login;

import android.util.Log;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.login.LoginResponse;
import com.example.nam.travel.views.login.ILoginActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/9/2018.
 */

public class LoginPresenter implements ILoginPresenter {
    public final String TAG = "LOGIN_PRESENTER";
    private ILoginActivity iLoginActivity;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
    }


    @Override
    public void getToken(String username, String password) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.getToken( username,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(TAG, String.valueOf(response.code()));
                if (response.code() == 400) {

                       iLoginActivity.getTokenFailure_WrongData();



                } else if (response.code() == 200) {
                    if (response.body().getResultCode() == 422) {
                        iLoginActivity.getTokenFailure_WrongData();
                    }
                    if (response.body().getResultCode() == 500) {
                        iLoginActivity.getTokenFailure_ServerError();
                    }
                    if (response.body().getResultCode() == 200) {
                        //Save token
                        MainActivity.token = response.body().getData();
                        String s = MainActivity.token;
                        iLoginActivity.getTokenSuccess(response.body().getData());
                    }
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d(TAG, "failure");
                iLoginActivity.getTokenFailure_ServerError();
            }
        });
    }
}
