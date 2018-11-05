package com.example.nam.travel.models.recommendLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 11/4/2018.
 */

public class RecommendLocationResponse {
    @SerializedName("result_code")
    @Expose
    private Integer resultCode;
    @SerializedName("result_message")
    @Expose
    private String resultMessage;
    @SerializedName("data")
    @Expose
    private List<RecommendLocation> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecommendLocationResponse() {
    }

    /**
     *
     * @param data
     * @param resultCode
     * @param resultMessage
     */
    public RecommendLocationResponse(Integer resultCode, String resultMessage, List<RecommendLocation> data) {
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

    public List<RecommendLocation> getData() {
        return data;
    }

    public void setData(List<RecommendLocation> data) {
        this.data = data;
    }
}
