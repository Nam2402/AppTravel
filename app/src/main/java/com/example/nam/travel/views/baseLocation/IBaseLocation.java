package com.example.nam.travel.views.baseLocation;

import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;

import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public interface IBaseLocation {
    public void getBaseLocationSuccess(List<BaseLocation> baseLocationList);

    public void getBaseLocationFailure();
}
