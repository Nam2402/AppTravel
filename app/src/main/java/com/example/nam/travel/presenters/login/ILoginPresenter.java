package com.example.nam.travel.presenters.login;

import okhttp3.RequestBody;

/**
 * Created by Nam on 11/9/2018.
 */

public interface ILoginPresenter {
    public void getToken(String username, String password);
}
