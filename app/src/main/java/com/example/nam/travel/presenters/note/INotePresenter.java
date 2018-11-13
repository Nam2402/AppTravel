package com.example.nam.travel.presenters.note;

import com.example.nam.travel.models.Note.Note;

public interface INotePresenter {
    public void noteLocation(Note note);

    public void editNoteLocation(Note note);

    public void getNoteLocation(Long idLocation);
}
