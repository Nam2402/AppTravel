package com.example.nam.travel.models.newLocation;

import com.example.nam.travel.models.location.Picture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nam on 10/31/2018.
 */

public class NewLocation {
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
    private String placeCategory;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("usersname")
    @Expose
    private Object usersname;
    @SerializedName("duration")
    @Expose
    private Object duration;
    @SerializedName("pictureList")
    @Expose
    private List<Picture> pictureList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewLocation() {
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
    public NewLocation(Integer id, String name, String introduction, String createdDate, String placeCategory, String content, String status, String address, String phone, String email, Object usersname, Object duration, List<Picture> pictureList) {
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

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }
}
