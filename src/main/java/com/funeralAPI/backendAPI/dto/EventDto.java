package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private int event_id;
    private int person_id;
    private String event_type;
    private String event_date;
    private String event_start_time;
    private String event_end_time;
    private String event_address;
}
