package com.aad_team_42.travelmanticsrebranded;

import android.app.Application;

import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseUtils.initializeFirebase(this);
    }
}