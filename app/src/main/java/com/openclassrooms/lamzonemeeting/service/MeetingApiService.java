package com.openclassrooms.lamzonemeeting.service;

import com.openclassrooms.lamzonemeeting.model.Meeting;

import java.util.Date;
import java.util.List;

/**
 * interface de l'api de gestions de réunions
 * methodes :
 * getMeeting qui retourne la liste des réunions selon le filtre actif
 * createMeeting qui ajoute la reunion en paramètre à la liste
 * deleteMeeting qui supprime la reunion en paramètre de la liste
 * filtreByDate qui retourne une liste filtrée par la date fournie en paramètre
 * filtreByPlace qui retourne une liste filtrée par lieu fourni en paramètre
 */
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
