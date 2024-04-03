package com.funeralAPI.backendAPI.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {


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


    private int family_id;
    private String full_name;
    private String relationship;
    private String prefull_name;
    private String prerelationship;
    private String mobile_number;
    private  boolean is_predeceased;



    private int contact_id;
    private String contact_name;
    private String contact_relationship;
    private String contact_mobile_number;


    private int education_id;
    private String primary_school;
    private String high_school;
    private String college;


    private int event_id;
    private String event_type;
    private String event_date;
    private String event_start_time;
    private String event_end_time;
    private String event_address;


    private int image_id;
    private String photo;
    private String memorial;
    private String background_image;


    private int about_id;
    private String about_name;
    private String about_relationship;
    private String about_mobile_number;
    private String about_email;
    private Boolean isTerm;


    private int story_id;
    private String description;


    private int category_id;
    private String category;





}
