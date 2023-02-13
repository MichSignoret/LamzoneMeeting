package com.openclassrooms.lamzonemeeting.di;

import com.openclassrooms.lamzonemeeting.service.DummyColorGenerator;
import com.openclassrooms.lamzonemeeting.service.DummyMeetingApiService;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;

public class DI {
    private static MeetingApiService service = new DummyMeetingApiService();

    public static MeetingApiService getMeetingApiService() { return service;}

    public static MeetingApiService getNewInstanceApiService(){
        return new DummyMeetingApiService();
    }

}
