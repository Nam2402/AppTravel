package com.example.nam.travel.views.recommendLocation;

import com.example.nam.travel.models.recommendLocation.RecommendLocation;

import java.util.List;

/**
 * Created by Nam on 11/4/2018.
 */

public interface IRecommendLocation {
    public void getRecommendLocationSuccess(List<RecommendLocation> recommendLocationList);

    public void getRecommendLocationFailure();
}
