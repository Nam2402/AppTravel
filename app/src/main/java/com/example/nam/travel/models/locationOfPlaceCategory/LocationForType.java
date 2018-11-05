package com.example.nam.travel.models.locationOfPlaceCategory;

import com.example.nam.travel.models.location.Picture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/20/2018.
 */

public class LocationForType {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("introduction")
    @Expose
    private String introduction;
    @SerializedName("pictureList")
    @Expose
    private List<Picture> pictureList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public LocationForType() {
    }

    /**
     *
     * @param name
     * @param pictureList
     * @param introduction
     */
    public LocationForType(Integer id, String name, String introduction, List<Picture> pictureList) {
        super();
        this.id = id;
        this.name = name;
        this.introduction = introduction;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    @Override
    public String toString() {
        return this.getId() + " | " + this.getName() + " | " + this.getIntroduction() + " | " + this.getPictureList().get(0).getImage();
    }
}
