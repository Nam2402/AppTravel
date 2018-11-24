package com.example.nam.travel.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.R;
import com.example.nam.travel.models.myProfile.MyProfile;
import com.example.nam.travel.presenters.myProfile.MyProfilePresenter;
import com.example.nam.travel.views.location.detailLocation.LoveLocationActivity;
import com.example.nam.travel.views.login.LoginActivity;
import com.example.nam.travel.views.myProfile.EditProfileActivity;
import com.example.nam.travel.views.myProfile.IMyProfileActivity;


public class ProfileFragment extends Fragment implements View.OnClickListener, IMyProfileActivity {
    String fullname, address, phone;
    Integer gender;
    ImageView imageView;
    TextView mylove;
    TextView logout;
    private TextView tvFullname,tvPhone, tvAddress,tvGender;
    private MyProfilePresenter myProfilePresenter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        initControls(view);
        getProfile();
        addEvents();
        return view;
    }

    public void initControls(View view){

        imageView = (ImageView) view.findViewById(R.id.edit);
        mylove = (TextView) view.findViewById(R.id.mylove);
        logout = (TextView) view.findViewById(R.id.logout);
        tvFullname = view.findViewById(R.id.fullname);
        tvPhone = view.findViewById(R.id.mobileNumber);
        tvAddress = view.findViewById(R.id.tv_address);
        tvGender = view.findViewById(R.id.gender);
        myProfilePresenter = new MyProfilePresenter(this);

    }
    private void getProfile() {

        String token = MainActivity.token;
        if (token != null) {
            myProfilePresenter.getMyProfile(token);
        } else {
            loadDefaultDataToView();
        }
    }

    @Override
    public void getMyProfileSuccess(MyProfile myProfile) {
        loadDataToView(myProfile);
    }

    private void loadDataToView(MyProfile myProfile) {
        tvFullname.setText(myProfile.getFullname());
        tvPhone.setText(myProfile.getPhone());
        tvAddress.setText(myProfile.getAddress());
        fullname = myProfile.getFullname();
        address = myProfile.getAddress();
        phone = myProfile.getPhone();
        gender = myProfile.getGender();
        if(myProfile.getGender() ==1){
            tvGender.setText("Nam");
        }else {
            tvGender.setText("Nữ");
        }

    }

    @Override
    public void getMyProfileFailure() {
        loadDefaultDataToView();
    }

    private void loadDefaultDataToView() {
        tvFullname.setText("--");
        tvPhone.setText("--");
        tvAddress.setText("--");
    }

    public void addEvents(){
        imageView.setOnClickListener(this);
        mylove.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.edit:
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                intent.putExtra("fullname",fullname);
                intent.putExtra("address",address);
                intent.putExtra("phone",phone);
                intent.putExtra("gender",gender);
                startActivity(intent);
                break;
            case R.id.mylove:
                startActivity(new Intent(getActivity(), LoveLocationActivity.class));
                break;
            case R.id.logout:
                startActivity(new Intent(getActivity(), LoginActivity.class) );
                break;

        }

    }

}