package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.EducationDto;
import com.funeralAPI.backendAPI.entity.Education;

public class EducationMapper {

     public static Education mapToEducation(EducationDto educationDto){
         return  new Education(
                 educationDto.getEducation_id(),
                 educationDto.getPerson_id(),
                 educationDto.getPrimary_school(),
                 educationDto.getHigh_school(),
                 educationDto.getCollege()
         );
     }

     public static EducationDto mapToEducationDto(Education education){
         return new EducationDto(
                 education.getEducation_id(),
                 education.getPerson_id(),
                 education.getPrimary_school(),
                 education.getHigh_school(),
                 education.getCollege()
         );

     }

}
