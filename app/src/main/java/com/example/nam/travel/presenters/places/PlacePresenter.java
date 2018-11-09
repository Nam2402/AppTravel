package com.example.nam.travel.presenters.places;

import android.widget.Toast;

import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.typePlace.TypeResponse;
import com.example.nam.travel.views.place.IPlaceActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nam on 10/17/2018.
 */

public class PlacePresenter implements IPlacePresenter {
    private IPlaceActivity iPlaceActivity;

    public PlacePresenter(IPlaceActivity iPlaceActivity) {
        this.iPlaceActivity = iPlaceActivity;
    }

    @Override
    public void getPlaceCategory(Long idType) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TypeResponse> call = apiService.getNameCategory(idType);
        call.enqueue(new Callback<TypeResponse>() {
            @Override
            public void onResponse(Call<TypeResponse> call, Response<TypeResponse> response) {
                if (response.code() >= 300) {
                    iPlaceActivity.getPlaceFailure();
                } else if (response.code() >= 200) {
                    TypeResponse typeResponse = response.body();
                    if (typeResponse.getResult_code() == 200) {

                       iPlaceActivity.getPlaceSuccess( typeResponse.getTypeDTO());

                    }
                } else {
                    iPlaceActivity.getPlaceFailure();
                }
            }
            @Override
            public void onFailure(Call<TypeResponse> call, Throwable t) {
                iPlaceActivity.getPlaceFailure();
            }
        });

    }
}
