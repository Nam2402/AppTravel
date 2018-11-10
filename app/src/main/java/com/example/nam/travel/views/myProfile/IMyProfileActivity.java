package com.example.nam.travel.views.myProfile;

import com.example.nam.travel.models.myProfile.MyProfile;

/**
 * Created by Nam on 11/10/2018.
 */

public interface IMyProfileActivity {
    public void getMyProfileSuccess(MyProfile myProfile);

    public void getMyProfileFailure();
}
