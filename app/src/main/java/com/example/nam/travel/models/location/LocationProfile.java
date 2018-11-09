package com.example.nam.travel.models.location;

import com.example.nam.travel.models.review.ReviewPagination;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */

public class LocationProfile {

    Long id;
    String name;
    String introduction;
    String content;
    String address;
    String latLng;
    String phone;
    String email;

    List<Picture> pictureList;
    boolean isFavorite;
    BigDecimal sumRating;
    long numRating;
    ReviewPagination evaluationPaginationDTO;

    public LocationProfile(Long id, String name, String introduction, String content, String address, String latLng, String phone, String email, List<Picture> pictureList, boolean isFavorite, BigDecimal sumRating, long numRating, ReviewPagination evaluationPaginationDTO) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.content = content;
        this.address = address;
        this.latLng = latLng;
        this.phone = phone;
        this.email = email;
        this.pictureList = pictureList;
        this.isFavorite = isFavorite;
        this.sumRating = sumRating;
        this.numRating = numRating;
        this.evaluationPaginationDTO = evaluationPaginationDTO;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng;
    }

    public String getLatLng() {
        return latLng;
    }

    public ReviewPagination getEvaluationPaginationDTO() {
        return evaluationPaginationDTO;
    }

    public void setEvaluationPaginationDTO(ReviewPagination evaluationPaginationDTO) {
        this.evaluationPaginationDTO = evaluationPaginationDTO;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }


    public void setNumRating(long numRating) {
        this.numRating = numRating;
    }

    public void setSumRating(BigDecimal sumRating) {
        this.sumRating = sumRating;
    }

    public BigDecimal getSumRating() {
        return sumRating;
    }

    public long getNumRating() {
        return numRating;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }



}
