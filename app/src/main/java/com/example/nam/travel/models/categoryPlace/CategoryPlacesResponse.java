package com.example.nam.travel.models.categoryPlace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */


public class CategoryPlacesResponse {

    @SerializedName("result_code")
    @Expose
    private Integer resultCode;
    @SerializedName("result_message")
    @Expose
    private String resultMessage;
    @SerializedName("data")
    @Expose
    private List<CategoryPlace> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryPlacesResponse() {
    }

    /**
     *
     * @param data
     * @param resultCode
     * @param resultMessage
     */
    public CategoryPlacesResponse(Integer resultCode, String resultMessage, List<CategoryPlace> data) {
        super();
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<CategoryPlace> getData() {
        return data;
    }

    public void setData(List<CategoryPlace> data) {
        this.data = data;
    }

}
