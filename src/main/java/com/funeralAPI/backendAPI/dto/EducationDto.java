package com.funeralAPI.backendAPI.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {


    private int education_id;
    private int person_id;
    private String primary_school;
    private String high_school;
    private String college;


}
