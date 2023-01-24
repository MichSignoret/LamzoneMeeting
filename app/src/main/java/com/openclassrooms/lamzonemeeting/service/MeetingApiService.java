package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingApiService {
    List<Meeting> getMeetings();
    Boolean filtreSalleIsActive=false;
    Boolean filtreDateIsActive=false;
    Date dateFilter = new Date();
    String placeFilter = "";
    void deleteMeeting(Meeting meetingToDelete);
    void createMeeting(Meeting meetingToCreate);
    List<Meeting> filtreByDate(List<Meeting> meetingList, Date dateToApply);
    List<Meeting> filtreByPlace(List<Meeting> meetingList, String placeToApply);

    Boolean getFiltreSalleIsActive();
    void setFiltreSalleIsActive(Boolean filtreSalleIsActive);
    Boolean getFiltreDateIsActive();
    void setFiltreDateIsActive(Boolean filtreDateIsActive);

    public void setPlaceFilter(String placeFilter);
    public String getPlaceFilter();
    public void setDateFilter(Date dateFilter);
    public Date getDateFilter();
}
