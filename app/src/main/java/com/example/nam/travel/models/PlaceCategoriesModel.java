package com.example.nam.travel.models;

import java.util.ArrayList;

/**
 * Created by Nam on 10/14/2018.
 */

public class PlaceCategoriesModel {
    private String headerTitle;
    private ArrayList<SingleItemModel> allItemInSection;

    public PlaceCategoriesModel() {
    }

    public PlaceCategoriesModel(String headerTitle, ArrayList<SingleItemModel> allItemInSection) {
        this.headerTitle = headerTitle;
        this.allItemInSection = allItemInSection;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllItemInSection() {
        return allItemInSection;
    }

    public void setAllItemInSection(ArrayList<SingleItemModel> allItemInSection) {
        this.allItemInSection = allItemInSection;
    }
}
