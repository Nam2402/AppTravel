package com.example.nam.travel.views.review;

import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.review.ReviewDTO;
import com.example.nam.travel.models.review.ReviewPagination;

public interface ICommentActivity {
    public void getReviewSuccess(ReviewDTO reviewDTO);

    public void getReviewFailure();

    public void addReviewSuccess();

    public void addReviewFailure();

    public void editReviewSuccess();

    public void editReviewFailure();
}
