package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.EventDto;
import com.funeralAPI.backendAPI.entity.Event;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.EventMapper;
import com.funeralAPI.backendAPI.repository.EventRepository;
import com.funeralAPI.backendAPI.services.EventService;

import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventService {

    private  EventRepository eventRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = EventMapper.mapToEvent(eventDto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto getEventById(int id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto updateEvent(int id, EventDto eventDto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));

        // Update event fields from the provided EventDto
        event.setPerson_id(eventDto.getPerson_id());
        event.setEvent_type(eventDto.getEvent_type());
        event.setEvent_date(eventDto.getEvent_date());
        event.setEvent_start_time(eventDto.getEvent_start_time());
        event.setEvent_end_time(eventDto.getEvent_end_time());
        event.setEvent_address(eventDto.getEvent_address());

        // Save the updated event
        Event updatedEvent = eventRepository.save(event);

        // Map the updated event to EventDto and return
        return EventMapper.mapToEventDto(updatedEvent);
    }

    @Override
    public void deleteEvent(int id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}
