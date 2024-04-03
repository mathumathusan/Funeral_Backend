package com.funeralAPI.backendAPI.controller;

import com.funeralAPI.backendAPI.dto.EventDto;
import com.funeralAPI.backendAPI.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class EventController{
    private EventService eventService;

    // Endpoint to create events
    @PostMapping("/event")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto savedEventDto = eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEventDto, HttpStatus.CREATED);
    }

    // Endpoint to get an event by ID
    @GetMapping("/event/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable int id) {
        EventDto eventDto = eventService.getEventById(id);
        return ResponseEntity.ok(eventDto);
    }

    // Endpoint to get all events
    @GetMapping("/event")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // Endpoint to update an event by ID
    @PutMapping("/event/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable int id, @RequestBody EventDto eventDto) {
        EventDto updatedEventDto = eventService.updateEvent(id, eventDto);
        return ResponseEntity.ok(updatedEventDto);
    }

    // Endpoint to delete an event by ID
    @DeleteMapping("/event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event with id " + id + " deleted successfully");
    }
}
