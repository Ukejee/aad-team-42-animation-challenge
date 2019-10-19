package com.aad_team_42.travelmanticsrebranded.activities;

import android.os.Bundle;

import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void RegisterUser(String email, String password){
        FirebaseUtils.signUpUser(this, email, password);
    }
}
