package com.example.nam.travel.models.categoryPlace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

}
