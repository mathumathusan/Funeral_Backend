package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private int person_id;
    private String first_name;
    private String last_name;
    private String nickname;
    private String gender;
    private String date_of_birth;
    private String place;
    private String place_of_birth_city;
    private String place_of_birth_country;
    private String date_of_death;
    private int    age_at_death;
    private String place_of_death_city;
    private String place_of_death_country;
    private String occupation;
    private String  funeral_date;
    private String funeral_start_time;
    private String funeral_end_time;
    private String funeral_home_address;
    private String virtual_service_url;
}
