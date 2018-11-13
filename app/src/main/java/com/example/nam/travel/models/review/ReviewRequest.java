package com.example.nam.travel.models.review;

public class ReviewRequest {
    private Long locationId;
    private Long numberRating;
    private String commentContent;


    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getNumberRating() {
        return numberRating;
    }

    public void setNumberRating(Long numberRating) {
        this.numberRating = numberRating;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public ReviewRequest(Long locationId, Long numberRating, String commentContent) {
        this.locationId = locationId;
        this.numberRating = numberRating;
        this.commentContent = commentContent;
    }
}
