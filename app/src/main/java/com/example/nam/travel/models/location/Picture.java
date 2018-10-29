package com.example.nam.travel.models.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {
    @SerializedName("id")
    @Expose
    Long id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("image")
    @Expose
    String image;

    @SerializedName("idLocation")
    @Expose
    Long idLocation;


    public  Picture(long id, String name , String link, Long idLocation){
        this.id = id;
        this.name = name;
        this.image = link;
        this.idLocation = idLocation;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }
}
