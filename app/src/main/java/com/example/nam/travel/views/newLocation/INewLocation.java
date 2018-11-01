package com.example.nam.travel.views.newLocation;

import com.example.nam.travel.models.newLocation.NewLocation;

import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public interface INewLocation {
    public void getNewLocationSuccess(List<NewLocation> newLocationList);

    public void getNewLocationFailure();
}
