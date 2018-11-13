package com.example.nam.travel.presenters.review;

import android.util.Log;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.api.ApiResponse;
import com.example.nam.travel.models.location.DetailLocationResponse;
import com.example.nam.travel.models.login.LoginResponse;
import com.example.nam.travel.models.review.ReviewPaginationResponse;
import com.example.nam.travel.models.review.ReviewRequest;
import com.example.nam.travel.presenters.detailLocation.IDetailLocationPresenter;
import com.example.nam.travel.views.location.detailLocation.IDetailLocationActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/5/2018.
 */

public class ReviewPresenter implements IReviewPresenter {

    private IDetailLocationActivity iDetailLocation;

    public ReviewPresenter(IDetailLocationActivity iDetailLocation) {
        this.iDetailLocation = iDetailLocation;
    }


    @Override
    public void getMoreReview(Long idLocation, int nextPage) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReviewPaginationResponse> call = apiService.getReviewPagination(idLocation, nextPage);
        call.enqueue(new Callback<ReviewPaginationResponse>() {
            @Override
            public void onResponse(Call<ReviewPaginationResponse> call, Response<ReviewPaginationResponse> response) {
                if (response.code() >= 300) {
                    iDetailLocation.getLoadMoreReviewFailure();
                } else if (response.code() >= 200) {
                    ReviewPaginationResponse detailLocationResponse = response.body();
                    if (detailLocationResponse.getResult_code() == 200) {
                        iDetailLocation.getLoadMoreReviewSuccess(detailLocationResponse.getData());
                    }
                } else {
                    iDetailLocation.getLoadMoreReviewFailure();                }
            }

            @Override
            public void onFailure(Call<ReviewPaginationResponse> call, Throwable t) {
                iDetailLocation.getDetailLocationFailure();
            }
        });

    }
}
