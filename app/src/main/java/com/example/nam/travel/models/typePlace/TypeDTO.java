package com.example.nam.travel.models.typePlace;

import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;
import com.example.nam.travel.models.locationOfPlaceCategory.LocationForType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



public class TypeDTO {
    @SerializedName("topLocationOfType")
    @Expose
    private LocationForType topLocationOfType;
    @SerializedName("listCategoryResponse")
    @Expose
    private ArrayList<CategoryResponseDTO> listCategoryResponse;

    public TypeDTO(LocationForType topLocationOfType, ArrayList<CategoryResponseDTO> listCategoryResponse) {
        this.topLocationOfType = topLocationOfType;
        this.listCategoryResponse = listCategoryResponse;
    }

    public LocationForType getTopLocationOfType() {
        return topLocationOfType;
    }

    public void setTopLocationOfType(LocationForType topLocationOfType) {
        this.topLocationOfType = topLocationOfType;
    }

    public ArrayList<CategoryResponseDTO> getListCategoryResponse() {
        return listCategoryResponse;
    }

    public void setListCategoryResponse(ArrayList<CategoryResponseDTO> listCategoryResponse) {
        this.listCategoryResponse = listCategoryResponse;
    }
}
