package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.EducationDto;

import java.util.List;

public interface EducationService {

    EducationDto createEducation(EducationDto educationDto);

    EducationDto getEducationById(int id);

    List<EducationDto> getAllEducations();

    EducationDto updateEducations(int id,EducationDto educationDto);

    void deleteEducationDetails(int id);

}
