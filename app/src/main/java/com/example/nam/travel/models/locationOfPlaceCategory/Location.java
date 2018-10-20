package com.example.nam.travel.models.locationOfPlaceCategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/20/2018.
 */

public class Location {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("introduction")
    @Expose
    private String introduction;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("placeCategory")
    @Expose
    private Object placeCategory;
    @SerializedName("content")
    @Expose
    private Object content;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("usersname")
    @Expose
    private Object usersname;
    @SerializedName("duration")
    @Expose
    private Object duration;
    @SerializedName("pictureList")
    @Expose
    private List<Object> pictureList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param content
     * @param id
     * @param duration
     * @param phone
     * @param usersname
     * @param email
     * @param address
     * @param status
     * @param placeCategory
     * @param name
     * @param pictureList
     * @param createdDate
     * @param introduction
     */
    public Location(Integer id, String name, String introduction, String createdDate, Object placeCategory, Object content, String status, Object address, Object phone, Object email, Object usersname, Object duration, List<Object> pictureList) {
        super();
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.createdDate = createdDate;
        this.placeCategory = placeCategory;
        this.content = content;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.usersname = usersname;
        this.duration = duration;
        this.pictureList = pictureList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Object getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(Object placeCategory) {
        this.placeCategory = placeCategory;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getUsersname() {
        return usersname;
    }

    public void setUsersname(Object usersname) {
        this.usersname = usersname;
    }

    public Object getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration = duration;
    }

    public List<Object> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Object> pictureList) {
        this.pictureList = pictureList;
    }

}
