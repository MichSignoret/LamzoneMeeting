package com.openclassrooms.lamzonemeeting.model;

import android.text.format.Time;

import java.util.Calendar;
import java.util.Date;

public class Meeting {
    private long id;
    String Name;
    String Place;


    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    Calendar date;


    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public Meeting(long id, String name, String place) {
        this.id = id;
        Name = name;
        Place = place;
    }

    public void setId(long id) {
        this.id = id;
    }
}
