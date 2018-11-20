package com.example.nam.travel.views.myProfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.R;
import com.example.nam.travel.presenters.myProfile.EditProfilePresenter;
import com.example.nam.travel.presenters.myProfile.IEditProfilePresenter;
import com.example.nam.travel.views.fragment.ProfileFragment;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener, IEditProfileActivity {
    private EditText edtName, edtAddress, edtPhone;
    private RadioGroup radioGroup;
    private RadioButton rdMale, rdFemale;
    private String fullname, address, phone;
    private ImageButton imageButton;
    private Integer gender;
    private Toolbar toolbar;
    private IEditProfilePresenter iEditProfilePresenter;
    private boolean isUpdate = false;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mapped();
        initCollapsingToolbar();
        imageButton.setOnClickListener(this);

    }

    public void mapped() {

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);
        rdMale = findViewById(R.id.radioMale);
        rdFemale = findViewById(R.id.radioFemale);
        imageButton = findViewById(R.id.imgBtnSave);
        iEditProfilePresenter = new EditProfilePresenter(this);
        getProfile();

    }
    public void getProfile() {
        Intent intent = getIntent();
        isUpdate = true;
            edtName.setText(intent.getStringExtra("fullname"));
            edtAddress.setText(intent.getStringExtra("address"));
            edtPhone.setText( intent.getStringExtra("phone"));
            if(intent.getIntExtra("gender",1) == 1){
                rdMale.setChecked(true);
            }else{
                rdFemale.setChecked(true);
        }

    }

    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Sửa thông tin");
        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnSave:
                if (checkValidField()) {

                passDataLoginToJson();
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
                String token = MainActivity.token;
//                if(isUpdate) {
                    iEditProfilePresenter.editProfile(body,token);
//                } else {
//
//                }
                } else {

                }

                break;
        }
    }

    private boolean checkValidField() {
        edtName.setError(null);
        edtAddress.setError(null);
        edtPhone.setError(null);
        boolean cancel = false;
        View focusView = null;
        fullname = edtName.getText().toString();
        address = edtAddress.getText().toString();
        phone = edtPhone.getText().toString();
        if(rdMale.isChecked()){
            gender = 1;
        } else {
            gender =0;
        }

        if (TextUtils.isEmpty(fullname)) {
            edtName.setError(getString(R.string.message_invalid_fullname_empty));
            focusView = edtName;
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

        return true;
    }

    private void passDataLoginToJson() {
        jsonObject = new JSONObject();
        try {
            jsonObject.put("address", address);
            jsonObject.put("phone", phone);
            jsonObject.put("gender", gender);
            jsonObject.put("fullname", fullname);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editProfileSuccess() {
        onBackPressed();
    }

    @Override
    public void editProfileFailure_ServerError() {

    }

    @Override
    public void editProfileFailure_WrongData() {

    }
}
