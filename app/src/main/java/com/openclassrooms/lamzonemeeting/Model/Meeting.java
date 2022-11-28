package com.openclassrooms.lamzonemeeting.Model;


import java.time.Clock;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Meeting {
    /** identifier */
    private long id;

    /** Name */
    private String name;

    /** Date */
    private Date dateMeeting;

    /** Heure de début */
    private Clock startHour;

    /** Heure de fin */
    private Clock endHour;

    /** Durée */
    private Duration meetingDuration;

    /** liste des participants */
    List <TeamMate> teamMateList;

    /** Emplacement */
    String place;

    public Meeting(long id, String name,String Location){
        this.id =id;
        this.name = name;
        this.place = Location;
    }

}
