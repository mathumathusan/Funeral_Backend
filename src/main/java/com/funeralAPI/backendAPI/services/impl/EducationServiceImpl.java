package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.EducationDto;
import com.funeralAPI.backendAPI.entity.Education;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.EducationMapper;
import com.funeralAPI.backendAPI.repository.EducationRepository;
import com.funeralAPI.backendAPI.services.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {

    EducationRepository educationRepository;

    @Override
    public EducationDto createEducation(EducationDto educationDto) {
        Education education= EducationMapper.mapToEducation(educationDto);
        Education savedEducation=  educationRepository.save(education);
        return EducationMapper.mapToEducationDto(savedEducation);
    }

    @Override
    public EducationDto getEducationById(int id) {

        Education education=  educationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("education not found"));
        return EducationMapper.mapToEducationDto(education);
    }

    @Override
    public List<EducationDto> getAllEducations() {

      List<Education> educations=  educationRepository.findAll();

        return educations.stream().map((education)->EducationMapper.mapToEducationDto(education)).collect(Collectors.toList());
    }

    @Override
    public EducationDto updateEducations(int id, EducationDto educationDto) {
       Education education= educationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("education not found"));
       education.setEducation_id(educationDto.getEducation_id());
       education.setPerson_id(educationDto.getPerson_id());
       education.setPrimary_school(educationDto.getPrimary_school());
       education.setHigh_school(educationDto.getHigh_school());
       education.setCollege(educationDto.getCollege());

       Education updatedEducation=educationRepository.save(education);

       return EducationMapper.mapToEducationDto(updatedEducation);

    }

    @Override
    public void deleteEducationDetails(int id) {
        Education education= educationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("education not found"));
        educationRepository.deleteById(id);
    }
}


