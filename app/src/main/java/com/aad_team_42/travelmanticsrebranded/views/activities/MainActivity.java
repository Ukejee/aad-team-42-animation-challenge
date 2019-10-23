package com.aad_team_42.travelmanticsrebranded.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.ZoomOutPageTransformer;
import com.aad_team_42.travelmanticsrebranded.adapters.ViewPagerAdapter;
import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;

import java.util.List;

public class MainActivity extends BaseActivity {
    private FirebaseAuth.AuthStateListener listener;
    Toolbar toolbar;
    TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.explore, R.drawable.favorite,R.drawable.event
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        tabLayout.setupWithViewPager(pager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpTabIcons();
        setUpListener();
    }

    private void setUpListener(){
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
                    moveToActivity(MainActivity.this, ChooseSignIn.class);
                    finish();
                }
            }
        };
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                break;
            case R.id.logout:
                FirebaseUtils.signOutUser(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}
