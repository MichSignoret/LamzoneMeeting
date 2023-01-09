package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.List;

public interface MeetingApiService {
    List<Meeting> getMeetings();
    void deleteMeeting(Meeting meetingToDelete);
    void createMeeting(Meeting meetingToCreate);

}
