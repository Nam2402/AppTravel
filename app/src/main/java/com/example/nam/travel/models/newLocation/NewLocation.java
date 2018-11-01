package com.example.nam.travel.models.newLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("idPlaceCategory")
    @Expose
    private Integer idPlaceCategory;
    @SerializedName("idContent")
    @Expose
    private Integer idContent;
    @SerializedName("idStatus")
    @Expose
    private Integer idStatus;
    @SerializedName("idAddress")
    @Expose
    private Integer idAddress;
    @SerializedName("idContact")
    @Expose
    private Integer idContact;
    @SerializedName("idUser")
    @Expose
    private Integer idUser;
    @SerializedName("idDuration")
    @Expose
    private Integer idDuration;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewLocation() {
    }

    /**
     *
     * @param id
     * @param idStatus
     * @param idContact
     * @param idDuration
     * @param name
     * @param idUser
     * @param idPlaceCategory
     * @param idContent
     * @param createdDate
     * @param idAddress
     * @param introduction
     */
    public NewLocation(Integer id, String name, String introduction, String createdDate, Integer idPlaceCategory, Integer idContent, Integer idStatus, Integer idAddress, Integer idContact, Integer idUser, Integer idDuration) {
        super();
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.createdDate = createdDate;
        this.idPlaceCategory = idPlaceCategory;
        this.idContent = idContent;
        this.idStatus = idStatus;
        this.idAddress = idAddress;
        this.idContact = idContact;
        this.idUser = idUser;
        this.idDuration = idDuration;
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

    public Integer getIdPlaceCategory() {
        return idPlaceCategory;
    }

    public void setIdPlaceCategory(Integer idPlaceCategory) {
        this.idPlaceCategory = idPlaceCategory;
    }

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdDuration() {
        return idDuration;
    }

    public void setIdDuration(Integer idDuration) {
        this.idDuration = idDuration;
    }
}
