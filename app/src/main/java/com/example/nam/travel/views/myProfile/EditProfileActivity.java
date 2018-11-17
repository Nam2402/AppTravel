package com.example.nam.travel.views.myProfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.nam.travel.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText edtName, edtAddress, edtPhone;
    private RadioGroup radioGroup;
    private RadioButton rdMale, rdFemale;
    private String fullname, address, phone;
    private Integer gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent intent = getIntent();
        fullname = intent.getStringExtra("fullname");
        address = intent.getStringExtra("address");
        phone = intent.getStringExtra("phone");
        gender = intent.getIntExtra("gender",1);
        mapped();
    }

    public void mapped() {

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);
        rdMale = findViewById(R.id.radioMale);
        rdFemale = findViewById(R.id.radioFemale);

        getProfile();

    }
    public void getProfile() {

            edtName.setText(fullname);
            edtAddress.setText(address);
            edtPhone.setText(phone);
            if(gender == 1){
                rdMale.setChecked(true);
            }else{
                rdFemale.setChecked(true);
        }

    }
}
