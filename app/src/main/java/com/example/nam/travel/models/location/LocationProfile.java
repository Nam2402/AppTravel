package com.example.nam.travel.models.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Nam on 10/17/2018.
 */

public class LocationProfile {
    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("introduction")
    @Expose
    String introduction;
    @SerializedName("createdDate")
    @Expose
    Date createdDate;
    @SerializedName("placeCategory")
    @Expose
    String placeCategory;
    @SerializedName("content")
    @Expose
    String content;
    @SerializedName("status")
    @Expose
    String  status;
    @SerializedName("address")
    @Expose
    String  address;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("usersname")
    @Expose
    String usersname;
    @SerializedName("duration")
    @Expose
    Long duration;

    @SerializedName("pictureList")
    @Expose
    List<Picture> pictureList;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }




}
