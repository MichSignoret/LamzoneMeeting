package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService{
    private List<Meeting> meetingsList = DummyMeetingGenerator.generateMeeting();

    @Override
    public List<Meeting> getMeetings() {
        return meetingsList;
    }

    @Override
    public void deleteMeeting(Meeting meetingToDelete) {
        meetingsList.remove(meetingToDelete);

    }

    @Override
    public void createMeeting(Meeting meetingToCreate) {
        meetingsList.add(meetingToCreate);
    }
}
