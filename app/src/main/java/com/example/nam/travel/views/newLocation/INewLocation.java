package com.example.nam.travel.views.newLocation;

import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;

import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public interface INewLocation {
    public void getNewLocationSuccess(List<BaseLocation> baseLocationList);

    public void getNewLocationFailure();
}
