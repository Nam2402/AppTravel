package com.example.nam.travel.views.location.allLocation;

import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;

import java.util.List;

/**
 * Created by Nam on 11/14/2018.
 */

public interface IAllLocationActivity {
    public void getAllLocationSuccess(CategoryResponseDTO categoryResponseDTOS);

    public void getAllLocationFailure();
}
