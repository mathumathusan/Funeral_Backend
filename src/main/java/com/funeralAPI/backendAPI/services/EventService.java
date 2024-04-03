package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.EventDto;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto);

    EventDto getEventById(int id);

    List<EventDto> getAllEvents();

    EventDto updateEvent(int id, EventDto eventDto);

    void deleteEvent(int id);
}
