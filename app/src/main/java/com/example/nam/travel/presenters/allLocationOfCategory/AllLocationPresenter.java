package com.example.nam.travel.presenters.allLocationOfCategory;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.categoryPlace.CategoryResponse;
import com.example.nam.travel.views.location.allLocation.IAllLocationActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 11/14/2018.
 */

public class AllLocationPresenter implements IAllLocationPresenter {
    private IAllLocationActivity iAllLocationActivity;

    public AllLocationPresenter(IAllLocationActivity iAllLocationActivity) {
        this.iAllLocationActivity = iAllLocationActivity;
    }

    @Override
    public void getAllLocation(Long idCat) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryResponse> call = apiService.getCategoryInfo(idCat);
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.code() >= 300) {
                    iAllLocationActivity.getAllLocationFailure();
                } else if (response.code() >= 200) {
                    CategoryResponse categoryResponse = response.body();
                    if (categoryResponse.getResult_code() == 200) {
                        iAllLocationActivity.getAllLocationSuccess(categoryResponse.getData());
                    }
                } else {

                    iAllLocationActivity.getAllLocationFailure();                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                iAllLocationActivity.getAllLocationFailure();            }
        });

    }
}
