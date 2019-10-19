package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends BaseActivity {
    private FirebaseAuth.AuthStateListener listener;
    Toolbar toolbar;
    TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.explore, R.drawable.favorite
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpTabIcons();
        setUpListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUtils.attachStateListener(listener);
    }

    @Override
    protected void onStop() {
        FirebaseUtils.detachStateListener(listener);
        super.onStop();
    }

    private void setUpListener(){
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
//                    moveToActivity(MainActivity.this, LoginActivity.class);
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void setUpTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
}
