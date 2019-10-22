package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aad_team_42.travelmanticsrebranded.R;

public class ChooseSignIn extends AppCompatActivity {
    TextView emailTv, googleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sign_in);
        init();
        emailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseSignIn.this, SignUpActivity.class));
            }
        });
        googleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseSignIn.this, MainActivity.class));
            }
        });
    }

    public void init() {
        emailTv = findViewById(R.id.email_option);
        googleTv = findViewById(R.id.google_option);
    }
}
