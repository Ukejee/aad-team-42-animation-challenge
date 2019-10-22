package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {
    protected static final int RC_SIGN_IN = 100;
    protected GoogleSignInClient mClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUtils.initializeGoogleSignIn(this);
        mClient = FirebaseUtils.getGoogleClient();
    }

    public void moveToActivity(FirebaseUser user, Context context, Class activity){
        Intent intent = new Intent(context, activity);
        intent.putExtra("User", user);
        startActivity(intent);
    }

    public void moveToActivity(Context context,  Class activity){
        Intent intent = new Intent(context, activity);
        startActivity(intent);
    }

    protected void loginUserWithGoogle(){
        Intent intent = mClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }
}
