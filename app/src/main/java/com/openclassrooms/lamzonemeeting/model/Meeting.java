package com.openclassrooms.lamzonemeeting.model;


import com.openclassrooms.lamzonemeeting.service.DummyColorGenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * classe Meeting la classe reunion contient les informations d'une réunion :
 * nom, lieu, date et heure de debut, participants et une couleur (générée en automatique aléatoirement)
 */
public class Meeting {
    private long id;
    String mName;
    String mPlace;
    Date mDateDebut;
    String mTeamMates;


    public int getmColorMeeting() {
        return mColorMeeting;
    }

    public void setmColorMeeting(int mColorMeeting) {
        this.mColorMeeting = mColorMeeting;
    }

    int mColorMeeting;

    public String getTeamMates() {
        return mTeamMates;
    }

    public void setTeamMates(String teamMates) {
        this.mTeamMates = teamMates;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public Date getmDateDebut() {
        return mDateDebut;
    }

    public void setmDateDebut(Date mDateDebut) {
        this.mDateDebut = mDateDebut;
    }

    /**
     *
     * id
     * name nom de la reunion
     * place lieu de la reunion
     * dateDebut date et heure de la reunion
     * teamMates participants à la reunion
     */
    public Meeting(long id, String name, String place, Date dateDebut,String teamMates) {
        this.id = id;
        mName = name;
        mPlace = place;
        mDateDebut = dateDebut;
        mTeamMates = teamMates;
        mColorMeeting = DummyColorGenerator.dummyColorReturn();

    }

    public void setId(long id) {
        this.id = id;
    }

    public String returnStartingHour(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
        SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
        String startingHour = sdf1.format(mDateDebut)+"h"+sdf2.format(mDateDebut);
        return startingHour;
    }
}
