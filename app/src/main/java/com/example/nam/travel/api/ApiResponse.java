package com.example.nam.travel.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("result_code")
    @Expose
    protected int result_code = 0;
    @SerializedName("result_message")
    @Expose
    protected String result_message = null;

    public ApiResponse(int result_code, String result_message) {
        this.result_code = result_code;
        this.result_message = result_message;
    }
    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }
}
