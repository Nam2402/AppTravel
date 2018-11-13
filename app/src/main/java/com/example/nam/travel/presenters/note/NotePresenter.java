package com.example.nam.travel.presenters.note;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.api.ApiResponse;
import com.example.nam.travel.models.Note.Note;
import com.example.nam.travel.models.Note.NoteReponse;
import com.example.nam.travel.views.note.INoteActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotePresenter implements INotePresenter {
    private INoteActivity iNoteActivity;

    public NotePresenter(INoteActivity iNoteActivity) {
        this.iNoteActivity = iNoteActivity;
    }

    @Override
    public void noteLocation(Note note) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.noteLocation(note, MainActivity.token);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iNoteActivity.noteLocationFailure();
                } else {
                    ApiResponse apiResponse = response.body();
                    if(apiResponse.getResult_code() == 200)
                        iNoteActivity.noteLocationSuccess();
                    else {
                        iNoteActivity.noteLocationFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iNoteActivity.noteLocationFailure();
            }
        });
    }

    @Override
    public void getNoteLocation(Long idLocation) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NoteReponse> call = apiService.getNoteOfUserForLocation(idLocation, MainActivity.token);
        call.enqueue(new Callback<NoteReponse>() {
            @Override
            public void onResponse(Call<NoteReponse> call, Response<NoteReponse> response) {
                //Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iNoteActivity.getNoteLocationFailure();
                } else {
                    NoteReponse noteReponse = response.body();
                    if(noteReponse.getResult_code() == 200)
                        iNoteActivity.getNoteLocationSuccess(noteReponse.getData());
                    else {
                        iNoteActivity.getNoteLocationFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<NoteReponse> call, Throwable t) {
                iNoteActivity.getNoteLocationFailure();
            }
        });
    }

    @Override
    public void editNoteLocation(Note note) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.editNoteLocation(note, MainActivity.token);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d(TAG, String.valueOf(response.code()));
                if (response.code() >= 300) {
                    iNoteActivity.editNoteLocationFailure();
                } else {
                    ApiResponse apiResponse = response.body();
                    if(apiResponse.getResult_code() == 200)
                        iNoteActivity.editNoteLocationSuccess();
                    else {
                        iNoteActivity.editNoteLocationFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iNoteActivity.editNoteLocationFailure();
            }
        });
    }
}
