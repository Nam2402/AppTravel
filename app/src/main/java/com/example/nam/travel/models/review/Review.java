package com.example.nam.travel.models.review;

import java.util.Date;

public class Review {
    private String nameUser;
    private Date dateReview;
    private Long score;
    private String content;

    public Review(String nameUser, String content, Long score, Date dateReview) {
        this.nameUser = nameUser;
        this.content = content;
        this.dateReview = dateReview;
        this.score = score;
    }

    public Review() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Date getDateReview() {
        return dateReview;
    }

    public Long getScore() {
        return score;
    }
}
