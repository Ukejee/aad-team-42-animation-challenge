package com.aad_team_42.travelmanticsrebranded.views.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText emailEdittext, passwordEdittext;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_with_mail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        findViewById(R.id.tv_sign_up).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);
        emailEdittext = findViewById(R.id.emailEditText);
        passwordEdittext = findViewById(R.id.passwordEditText);
        progressBar = findViewById(R.id.lgnProgressBar);
    }

    private void loginUserWithEmail(){
        if (!validateLoginCredentials()){
            return;
        }
        String email = emailEdittext.getText().toString();
        String password = passwordEdittext.getText().toString();
        FirebaseUtils.signInUserWithEmail(this, email, password);
    }

    private boolean validateLoginCredentials(){
        boolean valid = true;

        String email = emailEdittext.getText().toString();
        if (TextUtils.isEmpty(email)){
            emailEdittext.setError("Required");
            valid = false;
        } else if (!email.contains("@")){
            emailEdittext.setError("Invalid email address");
            valid = false;
        } else {
            emailEdittext.setError(null);
        }

        String password = passwordEdittext.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passwordEdittext.setError("Required");
            valid = false;
        } else if (password.length() < 8){
            passwordEdittext.setError("Password must be up to 8 characters");
            valid = false;
        } else {
            passwordEdittext.setError(null);
        }
        return valid;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_sign_up:
                moveToActivity(this, SignUpActivity.class);
                break;
            case R.id.button_login:
                loginUserWithEmail();
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void showProgressDialog(){
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        findViewById(R.id.button_login).setVisibility(View.INVISIBLE);
    }
}