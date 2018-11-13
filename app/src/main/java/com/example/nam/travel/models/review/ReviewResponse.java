package com.example.nam.travel.models.review;

import com.example.nam.travel.api.ApiResponse;

public class ReviewResponse extends ApiResponse {
    private ReviewDTO data;

    public ReviewResponse(int result_code, String result_message, ReviewDTO data) {
        super(result_code, result_message);
        this.data = data;
    }

    public ReviewDTO getData() {
        return data;
    }

    public void setData(ReviewDTO data) {
        this.data = data;
    }
}
