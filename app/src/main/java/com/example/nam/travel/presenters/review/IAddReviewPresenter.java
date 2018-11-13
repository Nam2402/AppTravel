package com.example.nam.travel.presenters.review;

import com.example.nam.travel.models.review.ReviewRequest;

/**
 * Created by Nam on 11/5/2018.
 */

public interface IAddReviewPresenter {
    public void addReview(ReviewRequest reviewRequest);

    public void getReview(Long idLocation);

    public void editReview(ReviewRequest reviewRequest);
}
