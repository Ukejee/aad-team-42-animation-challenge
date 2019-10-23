package com.aad_team_42.travelmanticsrebranded.views.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.utils.PreferencesUtils;

public class SplashScreenActivity extends BaseActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo  = findViewById(R.id.app_logo);

        setAnimation(logo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PreferencesUtils.openedBefore()) {
                    moveToActivity(SplashScreenActivity.this, MainActivity.class);
                    finish();
                } else {
                    moveToActivity(SplashScreenActivity.this, OnboardingActivity.class);
                    finish();
                    PreferencesUtils.setOpened(true);
                }
            }
        }, 2500);


    }

    private void setAnimation(View view){

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.set);

        animator.setTarget(view);
        animator.start();
    }

}
