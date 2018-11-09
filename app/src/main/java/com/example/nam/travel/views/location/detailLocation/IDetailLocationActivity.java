package com.example.nam.travel.views.location.detailLocation;

import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.review.ReviewPagination;
import com.example.nam.travel.models.typePlace.TypeDTO;

public interface IDetailLocationActivity {
    public void getDetailLocationSuccess(LocationProfile locationProfile);

    public void getDetailLocationFailure();

    public void getLoadMoreReviewSuccess(ReviewPagination reviewPagination);

    public void getLoadMoreReviewFailure();
}
