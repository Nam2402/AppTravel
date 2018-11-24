package com.example.nam.travel.views.signup;

/**
 * Created by Nam on 11/24/2018.
 */

public interface ISignupActivity {
    public void signupSuccess();

    public void signupFailure_ServerError();

    public void signupFailure_AccountExits();
}
