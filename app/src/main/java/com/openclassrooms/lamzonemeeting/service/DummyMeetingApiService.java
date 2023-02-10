package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * implémentation de l'API MeetingApiService
 * contient les méthodes de retour de la liste des réunions créées selon les filtres actifs
 * et les méthodes d'ajout ou de suppression de réunion à la liste des réunions
 */
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

    /**
     *
     * retourne la liste des réunions selon le filtre actifs :
     * si aucun filtre actif on retourne la liste complete
     * si filtre place actif on retourne la liste filtrée par place rendue par la méthode filtreByPlace
     * si filtre date actif on retourne la liste filtrée par date rendue par la méthode filtreByDate
     */
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

    /**
     *
     * supprime meetingToDelete en paramètre de la liste des réunions
     */
    @Override
    public void deleteMeeting(Meeting meetingToDelete) {
        meetingsList.remove(meetingToDelete);

    }

    /**
     *
     * ajoute meetingToCreate en paramètre à la liste des réunions
     */
    @Override
    public void createMeeting(Meeting meetingToCreate) {
        meetingsList.add(meetingToCreate);
    }

    /**
     *
     * filtre la liste fournie en paramètre selon la date fournie en paramètre
     * retounre la liste filtrée
     */
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

    /**
     * filtre la liste fournie en paramètre selon le lieu fourni en paramètre
     * retounre la liste filtrée
     */
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
