package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {
    protected static final int RC_SIGN_IN = 100;
    protected GoogleSignInClient mClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUtils.initializeGoogleSignIn(this);
        mClient = FirebaseUtils.getGoogleClient();
    }

    public void moveToActivity(FirebaseUser user, Context context, Class activity){
        Intent intent = new Intent(context, activity);
        intent.putExtra("User", user);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void moveToActivity(Context context,  Class activity){
        Intent intent = new Intent(context, activity);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
