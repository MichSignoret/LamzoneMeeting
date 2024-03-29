package com.openclassrooms.lamzonemeeting.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.openclassrooms.lamzonemeeting.R;
import com.openclassrooms.lamzonemeeting.di.DI;
import com.openclassrooms.lamzonemeeting.model.Meeting;
import com.openclassrooms.lamzonemeeting.service.DummyColorGenerator;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;

import org.w3c.dom.Text;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Ajout d'une reunion
 * à partir des données saisies sur l'interface on renseigne le nom, le lieu, la date (et l'heure), les participants
 * pour créer une réunion lors de l'appui sur le bouton add_button
 */
public class AddMeetingActivity extends AppCompatActivity {

    @BindView(R.id.meeting_name)
    TextInputEditText meetingName;
    @BindView(R.id.meeting_place)
    TextInputEditText meetingPlace;
    @BindView(R.id.meetingTextDate)
    TextInputEditText meetingDate;
    @BindView(R.id.meeting_startTime)
    TextInputEditText meetingStartTime;
    @BindView(R.id.meeting_teamMates)
    TextInputEditText teamMates;
    @BindView(R.id.add_button)
    MaterialButton addButton;

    private MeetingApiService mApiService;

    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);
        mApiService = DI.getMeetingApiService();
        init();
    }

    private void init() {
        meetingName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                addButton.setEnabled(s.length() > 0);
            }
        });
    }

    @OnClick(R.id.add_button)
    void addMeeting(){

        //recupération de la date
         String dateMeetingString = meetingDate.getText().toString();

        //recupération heure
        String startHourMeetingString = meetingStartTime.getText().toString();

        String dateAndTime =  dateMeetingString + " " + startHourMeetingString;

        Date dateMeeting= new Date();
        try {
            dateMeeting = new SimpleDateFormat( "dd/MM/yyyy HH:mm").parse(dateAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setTime(dateMeeting);

        Meeting meeting = new Meeting(System.currentTimeMillis(),
                meetingName.getText().toString(),
                meetingPlace.getText().toString(),calendar.getTime(),teamMates.getText().toString());
        mApiService.createMeeting(meeting);
        finish();
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
    @OnClick(R.id.backButton)
    void backOnListActivity(){
        AddMeetingActivity.this.finish();
    }
}