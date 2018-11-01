package com.example.nam.travel.models.newLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/31/2018.
 */

public class NewLocationResponse {
    @SerializedName("result_code")
    @Expose
    private Integer resultCode;
    @SerializedName("result_message")
    @Expose
    private String resultMessage;
    @SerializedName("data")
    @Expose
    private List<NewLocation> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewLocationResponse() {
    }

    /**
     *
     * @param data
     * @param resultCode
     * @param resultMessage
     */
    public NewLocationResponse(Integer resultCode, String resultMessage, List<NewLocation> data) {
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

    public List<NewLocation> getData() {
        return data;
    }

    public void setData(List<NewLocation> data) {
        this.data = data;
    }
}
