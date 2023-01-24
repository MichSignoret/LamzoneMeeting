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
import com.openclassrooms.lamzonemeeting.di.DI;
import com.openclassrooms.lamzonemeeting.model.Meeting;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    MeetingApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
//        mViewPager.setAdapter( mPagerAdapter);
        initView();

        sw1.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                apiService = DI.getMeetingApiService();
                if (isChecked) {
                    // La bascule est activée
                    apiService.setFiltreDateIsActive(true);
                    String dateInString = filterDate.getText().toString();
                    try {
                        apiService.setDateFilter(new SimpleDateFormat( "dd/MM/yyyy").parse(dateInString));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    sw2.setChecked(false);
                    initView();
                } else {
                    // La bascule est désactivée
                    apiService.setFiltreDateIsActive(false);
                    initView();
                }
            }
        });

        sw2.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                apiService = DI.getMeetingApiService();

                if (isChecked) {
                    // La bascule est activée
                    apiService.setFiltreSalleIsActive(true);
                    apiService.setPlaceFilter(filterPlace.getText().toString());
                    sw1.setChecked(false);
                    initView();
                } else {
                    // La bascule est désactivée
                    apiService.setFiltreSalleIsActive(false);
                    apiService.setPlaceFilter("");
                    initView();
                }
            }
        });

    }

    void initView(){
        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter( mPagerAdapter);
    }

    @OnClick(R.id.add_meeting)
    void addMeeting() {
        AddMeetingActivity.navigate(this);
    }
}