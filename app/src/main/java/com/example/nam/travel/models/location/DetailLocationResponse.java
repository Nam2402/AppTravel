package com.example.nam.travel.models.location;

import com.example.nam.travel.api.ApiResponse;
import com.example.nam.travel.models.typePlace.TypeDTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailLocationResponse extends ApiResponse {
    @SerializedName("data")
    @Expose
    private LocationProfile locationProfile;
    public DetailLocationResponse(int result_code, String result_message, LocationProfile locationProfile) {
        super(result_code,result_message);
        this.locationProfile = locationProfile;
    }

    public LocationProfile getData() {
        return locationProfile;
    }

    public void setData(LocationProfile locationProfile) {
        this.locationProfile = locationProfile;
    }
}
