package com.openclassrooms.lamzonemeeting.events;

import com.openclassrooms.lamzonemeeting.model.Meeting;

public class DeleteMeetingEvent {

    public Meeting meeting;

    public DeleteMeetingEvent(Meeting meeting) {

        this.meeting = meeting;
    }
}
