package com.aad_team_42.travelmanticsrebranded.views.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {

    private EditText nameEdittext, emailEdittext, passwordEdittext, confirmPasswordEdittext;
    private TextView signUpbutton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        signUpbutton = findViewById(R.id.sign_up_btn);
        signUpbutton.setOnClickListener(this);
        signUpbutton.setEnabled(false);
        nameEdittext = findViewById(R.id.name_edit_text);
        emailEdittext = findViewById(R.id.email_edit_text);
        passwordEdittext = findViewById(R.id.password_edit_text);
        confirmPasswordEdittext = findViewById(R.id.confirm_password_edit_text);
        confirmPasswordEdittext.addTextChangedListener(confirmPasswordWatcher);
        progressBar = findViewById(R.id.sgnProgressBar);
    }

    private void registerUser(){

        if (!validateSignupCredentials()){
            return;
        }

        String name = nameEdittext.getText().toString();
        String email = emailEdittext.getText().toString();
        String password = passwordEdittext.getText().toString();
        FirebaseUtils.signUpUserWithEmail(this, name, email, password);
    }

    private boolean validateSignupCredentials(){
        boolean valid = true;

        String name = nameEdittext.getText().toString();
        if (TextUtils.isEmpty(name)){
            nameEdittext.setError("Required");
            valid = false;
        } else{
            nameEdittext.setError(null);
        }

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

    private final TextWatcher confirmPasswordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) {
            String password = passwordEdittext.getText().toString();
            String confirmPassword = confirmPasswordEdittext.getText().toString();
            if (password.equals(confirmPassword)){
                confirmPasswordEdittext.setError("Password matches");
                signUpbutton.setEnabled(true);
            } else {
                confirmPasswordEdittext.setError("Password does not match");
                signUpbutton.setEnabled(true);
            }
        }
    };

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sign_up_btn) {
            registerUser();
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
        signUpbutton.setVisibility(View.GONE);
    }
}