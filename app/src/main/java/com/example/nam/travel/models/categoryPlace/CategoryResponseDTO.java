package com.example.nam.travel.models.categoryPlace;

import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class CategoryResponseDTO {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("listLocationOfCategory")
    @Expose
    private List<BaseLocation> listLocationOfCategory;

    public CategoryResponseDTO(Long id, String name, List<BaseLocation> listLocationOfCategory) {
        this.id = id;
        this.name = name;
        this.listLocationOfCategory = listLocationOfCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BaseLocation> getListLocationOfCategory() {
        return listLocationOfCategory;
    }

    public void setListLocationOfCategory(List<BaseLocation> listLocationOfCategory) {
        this.listLocationOfCategory = listLocationOfCategory;
    }

    public String allLocationInfo() {
        String result = "";
        for(BaseLocation baseLocation : listLocationOfCategory) {
            result = result + " \n " + baseLocation.toString();
        }

        return result;
    }
    @Override
    public String toString() {
        return "ID : " + id + " | NAME : " + name + " | " + allLocationInfo();
    }
}
