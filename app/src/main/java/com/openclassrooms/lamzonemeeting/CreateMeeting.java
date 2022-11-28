package com.openclassrooms.lamzonemeeting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.openclassrooms.lamzonemeeting.Model.Meeting;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateMeeting extends AppCompatActivity {

    @BindView(R.id.MeetingName)
    TextInputLayout meetingName;
    @BindView(R.id.MeetingLocation)
    TextInputLayout meetingLocation;
    @BindView(R.id.save_button)
    MaterialButton addButton;

    private MeetingApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);
    }

    @OnClick(R.id.save_button)
    void addMeeting() {
        Meeting newMeeting = new Meeting(
                System.currentTimeMillis(),
                meetingName.getEditText().getText().toString(),
                meetingLocation.getEditText().getText().toString());

        mApiService.createMeeting(newMeeting);
        finish();
    }

    /**
     * Used to navigate to this activity
     * @param activity
     */
    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, CreateMeeting.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}