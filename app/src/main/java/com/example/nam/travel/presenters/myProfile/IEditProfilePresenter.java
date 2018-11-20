package com.example.nam.travel.presenters.myProfile;

import okhttp3.RequestBody;

/**
 * Created by Nam on 11/20/2018.
 */

public interface IEditProfilePresenter {
    public void editProfile(RequestBody json, String token);
}
