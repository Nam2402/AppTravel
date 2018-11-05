package com.example.nam.travel.views.place;

import com.example.nam.travel.models.typePlace.TypeDTO;

/**
 * Created by Nam on 10/17/2018.
 */

public interface IPlaceActivity {
    public void getPlaceSuccess(TypeDTO categoryResponseDTOS);

    public void getPlaceFailure();
}
