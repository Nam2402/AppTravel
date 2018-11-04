package com.example.nam.travel.models.newLocation;

import com.example.nam.travel.models.location.Picture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/31/2018.
 */

public class NewLocation {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numRating")
    @Expose
    private Integer numRating;
    @SerializedName("sumRating")
    @Expose
    private Integer sumRating;
    @SerializedName("pictureList")
    @Expose
    private List<Picture> pictureList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewLocation() {
    }

    /**
     *
     * @param id
     * @param name
     * @param pictureList
     * @param numRating
     * @param sumRating
     */
    public NewLocation(Integer id, String name, Integer numRating, Integer sumRating, List<Picture> pictureList) {
        super();
        this.id = id;
        this.name = name;
        this.numRating = numRating;
        this.sumRating = sumRating;
        this.pictureList = pictureList;
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

    public Integer getNumRating() {
        return numRating;
    }

    public void setNumRating(Integer numRating) {
        this.numRating = numRating;
    }

    public Integer getSumRating() {
        return sumRating;
    }

    public void setSumRating(Integer sumRating) {
        this.sumRating = sumRating;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }
}
