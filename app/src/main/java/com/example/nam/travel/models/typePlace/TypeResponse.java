package com.example.nam.travel.models.typePlace;

import com.example.nam.travel.api.ApiResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypeResponse extends ApiResponse {
    @SerializedName("data")
    @Expose
    private TypeDTO typeDTO;
    public TypeResponse(int result_code, String result_message, TypeDTO typeDTO) {
        super(result_code,result_message);
        this.typeDTO = typeDTO;
    }

    public TypeDTO getTypeDTO() {
        return typeDTO;
    }

    public void setTypeDTO(TypeDTO typeDTO) {
        this.typeDTO = typeDTO;
    }
}
