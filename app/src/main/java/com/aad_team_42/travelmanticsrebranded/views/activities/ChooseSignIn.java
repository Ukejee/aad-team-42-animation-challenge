package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.lang.ref.WeakReference;

public class ChooseSignIn extends BaseActivity implements View.OnClickListener {
    private static final String TAG = ChooseSignIn.class.getSimpleName();
    TextView emailTv, googleTv;
    private static final int RC_SIGN_IN = 100;
    private GoogleSignInClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sign_in);
        init();
    }

    public void init() {
        emailTv = findViewById(R.id.email_option);
        googleTv = findViewById(R.id.google_option);
        emailTv.setOnClickListener(this);
        googleTv.setOnClickListener(this);
        FirebaseUtils.initializeGoogleSignIn(this);
        mClient = FirebaseUtils.getGoogleClient();
    }

    private void loginUserWithGoogle(){
        Intent intent = mClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if (account!= null) {
                    FirebaseUtils.firebaseAuthWithGoogle(this, account);
                }
            } catch (ApiException err){
                Log.w(TAG, "Google sign in failed", err);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.email_option:
                moveToActivity(this, LoginActivity.class);
                break;
            case R.id.google_option:
                loginUserWithGoogle();
                break;
        }
    }
}
