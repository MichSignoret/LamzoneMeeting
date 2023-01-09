package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1,"Reunion 1","Salle 1"),
            new Meeting(2,"Reunion 2","Salle 2"),
            new Meeting(3,"Reunion 3","Salle 2"));

    static List<Meeting> generateMeeting(){
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
