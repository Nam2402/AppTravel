package com.example.nam.travel.views.login;

/**
 * Created by Nam on 11/9/2018.
 */

public interface ILoginActivity {
    public void getTokenSuccess(String token);

    public void getTokenFailure_ServerError();

    public void getTokenFailure_WrongData();
}
