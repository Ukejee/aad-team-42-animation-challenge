package com.aad_team_42.travelmanticsrebranded.activities.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aad_team_42.travelmanticsrebranded.activities.fragments.ExploreFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                return new ExploreFragment();


            case 1:
                return new ExploreFragment();

            case 2:
                return new ExploreFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Explore";
                return title;
            case 1:
                title = "Favorites";
                return title;

            case 2:
                title = "Events";
                return title;
        }
        return super.getPageTitle(position);


    }

    @Override
    public int getCount() {
        return 3;
    }
}
