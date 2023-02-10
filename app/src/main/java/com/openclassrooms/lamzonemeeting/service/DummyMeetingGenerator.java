package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * classe de génération de réunion pour que l'appli ne soit pas vide au départ
 */
public abstract class DummyMeetingGenerator {
    static Calendar calendar = Calendar.getInstance();


    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1,"Reunion 1","Salle 1",calendarGenerator(),"peach@gmail.com"),
            new Meeting(2,"Reunion 2","Salle 2",calendarGenerator(),"mario@gmail.com, luigi@gmail.com"),
            new Meeting(3,"Reunion 3","Salle 2",calendarGenerator(),"mario@gmail.com"));

    /**
     *
     * retourne une liste de 3 réunions
     */
    static List<Meeting> generateMeeting(){
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    /**
     *
     * permet de customiser la date des réunions par défout
     */
    static Date calendarGenerator(){
        calendar.set(2023,01,18,10,30,0);
        return calendar.getTime();
    }
}
