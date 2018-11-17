package com.example.nam.travel.views.myProfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
    private Toolbar toolbar;

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
        initCollapsingToolbar();

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
}
