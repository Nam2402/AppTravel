package com.example.nam.travel.views.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.constant.Common;
import com.example.nam.travel.presenters.signup.SignUpPresenter;
import com.example.nam.travel.views.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;

import static com.example.nam.travel.constant.Constant.FULLNAME_INVALID_FORMAT_DISPLAY;
import static com.example.nam.travel.constant.Constant.LENGTH_OF_PASSWORD_MESSAGE_DISPLAY;
import static com.example.nam.travel.constant.Constant.PHONE_INVALID_FORMAT_DISPLAY;
import static com.example.nam.travel.constant.Constant.USERNAME_EXIST_MESSAGE_DISPLAY;

public class SignupActivity extends AppCompatActivity implements ISignupActivity, View.OnClickListener {
    Button btnLogin;
    private EditText edtFullName, edtUsername, edtPassword, edtAddress, edtPhone;
    private RadioButton rdMale, rdFemale;
    private Integer gender;
    private TextView tvErrorSomethingWrong;
    private SignUpPresenter signUpPresenter;
    private JSONObject jsonObject;
    private ProgressDialog progressDialog;
    private Button btnSignup;
    private String fullname,username, password, address, phone;

    private TextInputLayout usernameInputLayout, fullnameInputLayout,phoneInputLayout, passwordInputLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);

        // Capture button clicks
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(SignupActivity.this,
                        LoginActivity.class);
                startActivity(myIntent);
            }
        });
        init();
        setEvent();
    }
    private void setEvent() {
        btnSignup.setOnClickListener(this);
    }

    private void init() {
        signUpPresenter = new SignUpPresenter(this);
        tvErrorSomethingWrong = findViewById(R.id.tv_error_SomethingWrong);
        edtFullName = findViewById(R.id.edt_fullname);
        edtUsername = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtAddress = findViewById(R.id.edt_address);
        edtPhone = findViewById(R.id.edt_phone);
        rdMale = findViewById(R.id.radioMale);
        rdFemale = findViewById(R.id.radioFemale);
        btnSignup = findViewById(R.id.btn_signup);

        usernameInputLayout = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        fullnameInputLayout =  (TextInputLayout) findViewById(R.id.textInputLayoutFullname);
        phoneInputLayout = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(true);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                if (checkValidField()) {
                    passDataLoginToJson();
                    RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
                    if (Common.isConnected(getBaseContext())) {
                        signUpPresenter.signupAccount(body);
                        showProgressDialog(getString(R.string.message_sign_up));
                    } else {
                        showProgressDialog("No internet!");
                    }

                } else {

                }

                break;

        }
    }


    @Override
    public void signupSuccess() {
        Intent myIntent = new Intent(SignupActivity.this,
                LoginActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void signupFailure_ServerError() {
        progressDialog.dismiss();
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void signupFailure_AccountExits() {
        progressDialog.dismiss();
        tvErrorSomethingWrong.setVisibility(View.VISIBLE);

    }


    private boolean checkValidField() {
        edtFullName.setError(null);
        edtUsername.setError(null);
        edtPassword.setError(null);
        edtAddress.setError(null);
        edtPhone.setError(null);
        boolean cancel = false;
        View focusView = null;
        fullname = edtFullName.getText().toString();
        username = edtUsername.getText().toString();
        password = edtPassword.getText().toString();
        address = edtAddress.getText().toString();
        phone = edtPhone.getText().toString();
        if(rdMale.isChecked()){
            gender = 1;
        } else {
            gender =0;
        }

        if (TextUtils.isEmpty(fullname)) {
            edtFullName.setError(getString(R.string.message_invalid_fullname_empty));
            focusView = edtFullName;
            cancel = true;
            return false;
        }
        if (TextUtils.isEmpty(username)) {
            edtUsername.setError(getString(R.string.message_invalid_username_empty));
            focusView = edtUsername;
            cancel = true;
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            edtPassword.setError(getString(R.string.message_invalid_password_empty));
            focusView = edtPassword;
            cancel = true;
            return false;
        }

        if (TextUtils.isEmpty(address)) {
            edtAddress.setError(getString(R.string.message_invalid_address_empty));
            focusView = edtAddress;
            cancel = true;
            return false;
        }
        if (TextUtils.isEmpty(phone)) {
            edtPhone.setError(getString(R.string.message_invalid_phone_empty));
            focusView = edtPhone;
            cancel = true;
            return false;
        }
        if(fullname.length() < 5 || fullname.length() > 255) {
            fullnameInputLayout.setError(FULLNAME_INVALID_FORMAT_DISPLAY);
            return false;

        }else if(username.length() < 5 || username.length() > 255) {
            usernameInputLayout.setError(USERNAME_EXIST_MESSAGE_DISPLAY);
            return false;
        }
        else if(password.length() < 5 || password.length() > 70) {
            passwordInputLayout.setError(LENGTH_OF_PASSWORD_MESSAGE_DISPLAY);
            return false;
        }else if(phone.length() < 9 || phone.length() > 11) {
            phoneInputLayout.setError(PHONE_INVALID_FORMAT_DISPLAY);
            return false;
        }
        return true;
    }
    private void passDataLoginToJson() {
        jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            jsonObject.put("address", address);
            jsonObject.put("phone", phone);
            jsonObject.put("gender", gender);
            jsonObject.put("fullname", fullname);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void showProgressDialog(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();
    }
}
