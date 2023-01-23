package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService{
    private List<Meeting> meetingsList = DummyMeetingGenerator.generateMeeting();
    Boolean filtreSalleIsActive=false;
    Boolean filtreDateIsActive=false;
    Date dateFilter = new Date();
    String placeFilter = "";

    public Date getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(Date dateFilter) {
        this.dateFilter = dateFilter;
    }

    public String getPlaceFilter() {
        return placeFilter;
    }

    public void setPlaceFilter(String placeFilter) {
        this.placeFilter = placeFilter;
    }

    public Boolean getFiltreSalleIsActive() {
        return filtreSalleIsActive;
    }

    public void setFiltreSalleIsActive(Boolean filtreSalleIsActive) {
        this.filtreSalleIsActive = filtreSalleIsActive;
    }

    public Boolean getFiltreDateIsActive() {
        return filtreDateIsActive;
    }

    public void setFiltreDateIsActive(Boolean filtreDateIsActive) {
        this.filtreDateIsActive = filtreDateIsActive;
    }

    @Override
    public List<Meeting> getMeetings() {
        List<Meeting> resultList = new ArrayList<>();
        if (filtreSalleIsActive == true){
            resultList = filtreByPlace(meetingsList,placeFilter);
        }else
        if(filtreDateIsActive == true){
            resultList = filtreByDate(meetingsList,dateFilter);
        }else
        {
            resultList=meetingsList;
        }

        return resultList;
    }

    @Override
    public void deleteMeeting(Meeting meetingToDelete) {
        meetingsList.remove(meetingToDelete);

    }

    @Override
    public void createMeeting(Meeting meetingToCreate) {
        meetingsList.add(meetingToCreate);
    }

    @Override
    public List<Meeting> filtreByDate(List<Meeting> meetingList, Date dateToApply) {
        List<Meeting> resultList = new ArrayList<>();
        Calendar calendarI = Calendar.getInstance();
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(dateToApply);
        for (Meeting i: meetingList
             ) {
            calendarI.setTime(i.getmDateDebut());
                if((calendarI.get(Calendar.DAY_OF_MONTH)==calendarDate.get(Calendar.DAY_OF_MONTH))
                    & (calendarI.get(Calendar.MONTH)==calendarDate.get(Calendar.MONTH))
                    & (calendarI.get(Calendar.YEAR)==calendarDate.get(Calendar.YEAR)))
                {
                    resultList.add(i);
                }
        }

        return resultList;
    }

    @Override
    public List<Meeting> filtreByPlace(List<Meeting> meetingList, String placeToApply) {

        List<Meeting> resultList = new ArrayList<>();
        for (Meeting i: meetingList
        ) {
            if (i.getmPlace().equals(placeToApply)){
                resultList.add(i);
            }
        }

        return resultList;
    }


}
