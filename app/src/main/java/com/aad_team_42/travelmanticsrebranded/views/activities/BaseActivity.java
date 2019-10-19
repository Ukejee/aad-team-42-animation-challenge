package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void moveToActivity(FirebaseUser user,Context context,  Class activity){
        Intent intent = new Intent(context, activity);
        intent.putExtra("User", user);
        startActivity(intent);
        finish();
    }

    public void moveToActivity(Context context,  Class activity){
        Intent intent = new Intent(context, activity);
        startActivity(intent);
        finish();
    }
}
