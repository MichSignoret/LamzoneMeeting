package com.openclassrooms.lamzonemeeting.ui;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;
import com.openclassrooms.lamzonemeeting.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.meetingTextDate)
    TextInputEditText filterDate;
    @BindView(R.id.meetingPlace)
    TextInputEditText filterPlace;
    @BindView(R.id.switch1)
    Switch sw1;
    @BindView(R.id.switch2)
    Switch sw2;

    ListMeetingPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter( mPagerAdapter);

        sw1.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // La bascule est activée
                    Log.d(TAG, "onCheckedChanged: true");
                } else {
                    // La bascule est désactivée
                }
            }
        });

        sw2.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // La bascule est activée
                } else {
                    // La bascule est désactivée
                }
            }
        });

    }

    @OnClick(R.id.add_meeting)
    void addMeeting() {
        AddMeetingActivity.navigate(this);
    }
}