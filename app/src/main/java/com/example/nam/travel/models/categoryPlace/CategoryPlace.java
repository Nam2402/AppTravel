package com.example.nam.travel.models.categoryPlace;

import com.example.nam.travel.models.locationOfPlaceCategory.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */

public class CategoryPlace {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("idPlaceType")
    @Expose
    private Integer idPlaceType;

    private List<Location> locationList;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryPlace() {
    }

    /**
     *
     * @param id
     * @param idPlaceType
     * @param name
     */
    public CategoryPlace(Integer id, String name, Integer idPlaceType) {
        super();
        this.id = id;
        this.name = name;
        this.idPlaceType = idPlaceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdPlaceType() {
        return idPlaceType;
    }

    public void setIdPlaceType(Integer idPlaceType) {
        this.idPlaceType = idPlaceType;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}
