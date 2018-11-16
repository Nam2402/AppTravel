package com.example.nam.travel.models.categoryPlace;

import com.example.nam.travel.api.ApiResponse;


public class CategoryResponse extends ApiResponse {
    private CategoryResponseDTO data;

    public CategoryResponseDTO getData() {
        return data;
    }

    public void setData(CategoryResponseDTO data) {
        this.data = data;
    }

    public CategoryResponse(int result_code, String result_message, CategoryResponseDTO data) {
        super(result_code, result_message);
        this.data = data;
    }
}
