package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.Model.Meeting;

import java.util.List;

public class DummMeetingApiService implements MeetingApiService{

    private List <Meeting> meetingList;

    @Override
    public List<Meeting> getMeeting() {
        return meetingList;
    }

    @Override
    public void deleteMeeting(Meeting meetingToDelete) {
        meetingList.remove(meetingToDelete);
    }

    @Override
    public void createMeeting(Meeting meetingToCreate) {
        meetingList.add(meetingToCreate);
    }
}
