package com.example.nam.travel.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nam.travel.R;

public class LoginActivity extends AppCompatActivity  {
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignup = (Button) findViewById(R.id.btn_sign_up);

        // Capture button clicks
        btnSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(LoginActivity.this,
                        SignupActivity.class);
                startActivity(myIntent);
            }
        });
    }


}
