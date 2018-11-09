package com.example.nam.travel.models.locationOfPlaceCategory;

import com.example.nam.travel.models.location.Picture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nam on 10/20/2018.
 */

public class BaseLocation {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numRating")
    @Expose
    private long numRating;
    @SerializedName("sumRating")
    @Expose
    private BigDecimal sumRating;

    @SerializedName("pictureList")
    @Expose
    private List<Picture> pictureList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BaseLocation() {
    }

    /**
     *
     * @param name
     * @param pictureList
     */
    public BaseLocation(Long id, String name, long numRating, BigDecimal sumRating, List<Picture> pictureList) {
        super();
        this.id = id;
        this.name = name;
        this.sumRating = sumRating;
        this.numRating = numRating;
        this.pictureList = pictureList;
    }

    public void setSumRating(BigDecimal sumRating) {
        this.sumRating = sumRating;
    }

    public void setNumRating(long numRating) {
        this.numRating = numRating;
    }

    public long getNumRating() {
        return numRating;
    }

    public BigDecimal getSumRating() {
        return sumRating;
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

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    @Override
    public String toString() {
        return this.getId() + " | " + this.getName() + " | "  + this.getNumRating()+ " | " + this.getSumRating() + " | " + this.getPictureList().get(0).getImage();
    }
}
