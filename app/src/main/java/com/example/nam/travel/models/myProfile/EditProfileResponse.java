package com.example.nam.travel.models.myProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nam on 11/20/2018.
 */

public class EditProfileResponse {
    @SerializedName("result_code")
    @Expose
    private Integer resultCode;
    @SerializedName("result_message")
    @Expose
    private String resultMessage;
    @SerializedName("data")
    @Expose
    private EditProfile data;

    /**
     * No args constructor for use in serialization
     *
     */
    public EditProfileResponse() {
    }

    /**
     *
     * @param data
     * @param resultCode
     * @param resultMessage
     */
    public EditProfileResponse(Integer resultCode, String resultMessage, EditProfile data) {
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

    public EditProfile getData() {
        return data;
    }

    public void setData(EditProfile data) {
        this.data = data;
    }
}
