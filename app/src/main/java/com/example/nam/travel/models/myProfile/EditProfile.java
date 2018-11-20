package com.example.nam.travel.models.myProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nam on 11/20/2018.
 */

public class EditProfile {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idUser")
    @Expose
    private Integer idUser;
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
    public EditProfile() {
    }

    /**
     *
     * @param id
     * @param phone
     * @param address
     * @param gender
     * @param idUser
     * @param fullname
     */
    public EditProfile(Integer id, Integer idUser, String address, String phone, Integer gender, String fullname) {
        super();
        this.id = id;
        this.idUser = idUser;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.fullname = fullname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
