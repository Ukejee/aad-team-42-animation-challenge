package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.aad_team_42.travelmanticsrebranded.R;

public class SplashScreenActivity extends AppCompatActivity {

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
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(new Intent(getApplicationContext(), OnboardingActivity.class));
                finish();
            }
        }, 2000);


    }

    private void setAnimation(View view){

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.set);

        animator.setTarget(view);
        animator.start();
    }

}
