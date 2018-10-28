package com.example.nam.travel.models.categoryPlace;

import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.locationOfPlaceCategory.LocationForType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
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
    private List<LocationForType> listLocationOfCategory;

    public CategoryResponseDTO(Long id, String name, List<LocationForType> listLocationOfCategory) {
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

    public List<LocationForType> getListLocationOfCategory() {
        return listLocationOfCategory;
    }

    public void setListLocationOfCategory(List<LocationForType> listLocationOfCategory) {
        this.listLocationOfCategory = listLocationOfCategory;
    }
}
