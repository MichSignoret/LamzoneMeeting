package com.openclassrooms.lamzonemeeting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.lamzonemeeting.di.DI;
import com.openclassrooms.lamzonemeeting.model.Meeting;
import com.openclassrooms.lamzonemeeting.service.DummyColorGenerator;
import com.openclassrooms.lamzonemeeting.service.DummyMeetingGenerator;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MeetingServiceTest {
    private MeetingApiService service;


   @Before
   public void setup(){
       service = DI.getMeetingApiService();
   }

    @Test
    public void getMeetingWithSuccess() {
        List<Meeting> expectedMeeting = DummyMeetingGenerator.DUMMY_MEETINGS;
        assertNotNull(expectedMeeting);
        assertTrue(service.getMeetings().size()>0);
    }

    @Test
    public void deleteMeetingWithSucess() {
        Meeting meetingToDelete = service.getMeetings().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetings().contains(meetingToDelete));
    }

    @Test
    public void addMeetingWithSuccess(){
        Calendar calendar = Calendar.getInstance();
        Meeting meetingToAdd = new Meeting(1,"Reunion test","Salle test",calendar.getTime(),"test@gmail.com");
        service.createMeeting(meetingToAdd);
        assertTrue(service.getMeetings().contains(meetingToAdd));

    }

    @Test
    public void filtreByPlace() throws ParseException {
        Date dateMeeting = new SimpleDateFormat( "dd/MM/yyyy HH:mm").parse("25/01/2023 10:00");
        Meeting meetingToAdd = new Meeting(1,"Reunion test","Salle test2",dateMeeting,"test@gmail.com");
        service.createMeeting(meetingToAdd);
        List<Meeting> listMeeting = service.filtreByPlace(service.getMeetings(),"Salle test2");
        assertTrue(listMeeting.size()==1);
    }

    @Test
    public void filtreByDate() throws ParseException {
        Date dateMeeting = new SimpleDateFormat( "dd/MM/yyyy HH:mm").parse("25/01/2023 10:00");
        Meeting meetingToAdd = new Meeting(1,"Reunion test","Salle test",dateMeeting,"test@gmail.com");
        service.createMeeting(meetingToAdd);
        List<Meeting> listMeeting = service.filtreByDate(service.getMeetings(),dateMeeting);
        assertTrue(listMeeting.size()==1);
    }

}