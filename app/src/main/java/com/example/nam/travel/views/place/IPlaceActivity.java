package com.example.nam.travel.views.place;

import com.example.nam.travel.models.categoryPlace.CategoryPlace;
import com.example.nam.travel.models.locationOfPlaceCategory.Location;

import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */

public interface IPlaceActivity {
    public void getPlaceSuccess(List<CategoryPlace> categoryPlaceList);

    public void getPlaceFailure();

    public void getLocationSuccess(List<Location> locationList);

    public void getLocationFailure();
}
