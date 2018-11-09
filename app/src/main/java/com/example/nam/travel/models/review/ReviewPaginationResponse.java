package com.example.nam.travel.models.review;

import com.example.nam.travel.api.ApiResponse;

public class ReviewPaginationResponse extends ApiResponse {
    private ReviewPagination data;

    public ReviewPagination getData() {
        return data;
    }

    public void setData(ReviewPagination data) {
        this.data = data;
    }

    public ReviewPaginationResponse(int result_code, String result_message, ReviewPagination data) {
        super(result_code, result_message);
        this.data = data;
    }
}
