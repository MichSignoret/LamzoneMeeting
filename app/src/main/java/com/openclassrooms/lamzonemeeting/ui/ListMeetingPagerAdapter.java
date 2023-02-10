package com.openclassrooms.lamzonemeeting.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ListMeetingPagerAdapter extends FragmentPagerAdapter {
    public ListMeetingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return MeetingFragment.newInstance();
    }



    @Override
    public int getCount() {
        return 1;
    }
}
