package com.htd.music.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SongPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public SongPagerAdapter(@NonNull FragmentManager fm, Fragment... fragments) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Song";
            case 1:
                return "Albums";
            case 2:
                return "Artist";
        }

        return super.getPageTitle(position);
    }
}
