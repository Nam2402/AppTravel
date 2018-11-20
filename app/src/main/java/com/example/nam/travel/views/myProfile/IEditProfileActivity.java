package com.example.nam.travel.views.myProfile;

/**
 * Created by Nam on 11/20/2018.
 */

public interface IEditProfileActivity {
    public void editProfileSuccess();

    public void editProfileFailure_ServerError();

    public void editProfileFailure_WrongData();
}
