package com.example.nam.travel.presenters.review;

import android.util.Log;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.api.ApiResponse;
import com.example.nam.travel.models.login.LoginResponse;
import com.example.nam.travel.models.review.ReviewPaginationResponse;
import com.example.nam.travel.models.review.ReviewRequest;
import com.example.nam.travel.models.review.ReviewResponse;
import com.example.nam.travel.views.location.detailLocation.IDetailLocationActivity;
import com.example.nam.travel.views.review.ICommentActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/5/2018.
 */

public class AddReviewPresenter implements IAddReviewPresenter {

    private ICommentActivity iCommentActivity;

    public AddReviewPresenter(ICommentActivity iCommentActivity) {
        this.iCommentActivity = iCommentActivity;
    }

    public  void addReview(ReviewRequest reviewRequest) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.reviewLocation(reviewRequest, MainActivity.token);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iCommentActivity.addReviewFailure();
                } else {
                    ApiResponse apiResponse = response.body();
                    if(apiResponse.getResult_code() == 200)
                        iCommentActivity.addReviewSuccess();
                    else {
                        iCommentActivity.addReviewFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iCommentActivity.addReviewFailure();
            }
        });
    }


    public  void editReview(ReviewRequest reviewRequest) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.editReviewLocation(reviewRequest, MainActivity.token);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iCommentActivity.editReviewFailure();
                } else {
                    ApiResponse apiResponse = response.body();
                    if(apiResponse.getResult_code() == 200)
                        iCommentActivity.editReviewSuccess();
                    else {
                        iCommentActivity.editReviewFailure();
                    }
                }
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iCommentActivity.editReviewFailure();
            }
        });
    }


    @Override
    public  void getReview(Long idLocation) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReviewResponse> call = apiService.getReviewOfUserForLocation(idLocation, MainActivity.token);
        call.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                if (response.code() >= 300) {
                    iCommentActivity.getReviewFailure();
                } else {
                    ReviewResponse reviewResponse = response.body();
                    if(reviewResponse.getResult_code() == 200)
                        iCommentActivity.getReviewSuccess(reviewResponse.getData());
                    else {
                        iCommentActivity.getReviewFailure();
                    }
                }
            }
            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                iCommentActivity.getReviewFailure();
            }
        });
    }
    
}
