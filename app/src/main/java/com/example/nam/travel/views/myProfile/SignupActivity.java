package com.example.nam.travel.views.myProfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nam.travel.R;
import com.example.nam.travel.views.login.LoginActivity;

public class SignupActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnLogin = (Button) findViewById(R.id.btn_sign_up);

        // Capture button clicks
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(SignupActivity.this,
                        LoginActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
