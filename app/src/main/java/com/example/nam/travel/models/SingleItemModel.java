package com.example.nam.travel.models;

/**
 * Created by Nam on 10/14/2018.
 */

public class SingleItemModel {
    private String name, url, description;


    public SingleItemModel() {

    }

    public SingleItemModel(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
