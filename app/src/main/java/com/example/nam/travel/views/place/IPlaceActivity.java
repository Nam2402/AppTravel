package com.example.nam.travel.views.place;

import com.example.nam.travel.models.categoryPlace.CategoryPlace;

import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */

public interface IPlaceActivity {
    public void getPlaceSuccess(List<CategoryPlace> categoryPlaceList);

    public void getPlaceFailure();
}
