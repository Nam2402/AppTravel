package com.example.nam.travel.presenters.signup;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.signup.SignUpResponse;
import com.example.nam.travel.views.signup.ISignupActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/24/2018.
 */

public class SignUpPresenter implements ISignUpPresenter {
    private ISignupActivity iSignupActivity;

    public SignUpPresenter(ISignupActivity iSignupActivity) {
        this.iSignupActivity = iSignupActivity;
    }

    @Override
    public void signupAccount(RequestBody json) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SignUpResponse> call = apiService.signupAccount(json);
        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.code() >=300) {

                    iSignupActivity.signupFailure_ServerError();

                } else if (response.code() == 200) {
                    if (response.body().getResultCode() == 500) {
                        iSignupActivity.signupFailure_AccountExits();
                    }
                    if (response.body().getResultCode() == 200) {
                        //Save token
                        iSignupActivity.signupSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                iSignupActivity.signupFailure_ServerError();
            }
        });
    }
}
