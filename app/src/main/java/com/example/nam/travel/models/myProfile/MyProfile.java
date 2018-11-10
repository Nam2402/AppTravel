package com.example.nam.travel.models.myProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nam on 11/10/2018.
 */

public class MyProfile {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("fullname")
    @Expose
    private String fullname;

    /**
     * No args constructor for use in serialization
     *
     */
    public MyProfile() {
    }

    /**
     *
     * @param phone
     * @param username
     * @param address
     * @param gender
     * @param fullname
     */
    public MyProfile(String username, String address, String phone, Integer gender, String fullname) {
        super();
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
