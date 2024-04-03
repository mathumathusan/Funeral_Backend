package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.EventDto;
import com.funeralAPI.backendAPI.entity.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){
        return new Event(
                eventDto.getEvent_id(),
                eventDto.getPerson_id(),
                eventDto.getEvent_type(),
                eventDto.getEvent_date(),
                eventDto.getEvent_start_time(),
                eventDto.getEvent_end_time(),
                eventDto.getEvent_address()
        );
    }

    public static EventDto mapToEventDto(Event event){
        return new EventDto(
                event.getEvent_id(),
                event.getPerson_id(),
                event.getEvent_type(),
                event.getEvent_date(),
                event.getEvent_start_time(),
                event.getEvent_end_time(),
                event.getEvent_address()
        );
    }
}
