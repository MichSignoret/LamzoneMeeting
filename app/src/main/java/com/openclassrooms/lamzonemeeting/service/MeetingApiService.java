package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.Model.Meeting;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeeting();

    void deleteMeeting(Meeting meetingToDelete);

    void createMeeting(Meeting meetingToCreate);


}
