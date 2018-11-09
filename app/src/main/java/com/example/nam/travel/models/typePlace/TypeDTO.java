package com.example.nam.travel.models.typePlace;

import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



public class TypeDTO {
    @SerializedName("topLocationOfType")
    @Expose
    private BaseLocation topLocationOfType;
    @SerializedName("listCategoryResponse")
    @Expose
    private ArrayList<CategoryResponseDTO> listCategoryResponse;

    public TypeDTO(BaseLocation topLocationOfType, ArrayList<CategoryResponseDTO> listCategoryResponse) {
        this.topLocationOfType = topLocationOfType;
        this.listCategoryResponse = listCategoryResponse;
    }

    public BaseLocation getTopLocationOfType() {
        return topLocationOfType;
    }

    public void setTopLocationOfType(BaseLocation topLocationOfType) {
        this.topLocationOfType = topLocationOfType;
    }

    public ArrayList<CategoryResponseDTO> getListCategoryResponse() {
        return listCategoryResponse;
    }

    public void setListCategoryResponse(ArrayList<CategoryResponseDTO> listCategoryResponse) {
        this.listCategoryResponse = listCategoryResponse;
    }


    public String allLocationInfo() {
        String result = "";
        for(CategoryResponseDTO locationForType : listCategoryResponse) {
            result = result + " \n " + locationForType.toString();
        }

        return result;
    }

    @Override
    public String toString() {
        return "topLocationOfTtype : " + topLocationOfType.toString() + " \n " +
                "listCate : " + allLocationInfo();
    }
}
