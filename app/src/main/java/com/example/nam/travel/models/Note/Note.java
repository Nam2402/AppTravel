package com.example.nam.travel.models.Note;

public class Note {
    private Long idLocation;
    private String content;

    public Note(Long idLocation, String note) {
        this.idLocation = idLocation;
        this.content = note;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public String getNote() {
        return content;
    }

    public void setNote(String note) {
        this.content = note;
    }
}
