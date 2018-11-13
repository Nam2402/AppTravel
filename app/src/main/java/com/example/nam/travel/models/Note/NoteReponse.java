package com.example.nam.travel.models.Note;

import com.example.nam.travel.api.ApiResponse;

public class NoteReponse extends ApiResponse {
    private String data;

    public NoteReponse(int result_code, String result_message, String data) {
        super(result_code, result_message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
