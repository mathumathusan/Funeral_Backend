package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {
    private int about_id;
    private int person_id;
    private String about_name;
    private String about_relationship;
    private String about_mobile_number;
    private String about_email;
    private Boolean isTerm;
}
