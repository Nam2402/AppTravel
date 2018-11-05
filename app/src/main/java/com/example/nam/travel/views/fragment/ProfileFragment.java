package com.example.nam.travel.views.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.views.login.EditProfileActivity;
import com.example.nam.travel.views.login.LoginActivity;
import com.example.nam.travel.views.login.SignupActivity;


public class ProfileFragment extends Fragment implements View.OnClickListener {
    ImageView imageView;
    TextView logout;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        initControls(view);
        addEvents();
        return view;
    }

    public void initControls(View view){

        imageView = (ImageView) view.findViewById(R.id.edit);
        logout = (TextView) view.findViewById(R.id.logout);

    }

    public void addEvents(){
        imageView.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.edit:
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
                break;
            case R.id.logout:
                startActivity(new Intent(getActivity(), SignupActivity.class) );



        }

    }
}
