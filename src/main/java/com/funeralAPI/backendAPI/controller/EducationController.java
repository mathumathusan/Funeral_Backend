package com.funeralAPI.backendAPI.controller;


import com.funeralAPI.backendAPI.dto.EducationDto;
import com.funeralAPI.backendAPI.services.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/funeral")
public class EducationController {

    EducationService educationService;

    // post the education details in database
    @PostMapping("/education")
    public ResponseEntity<EducationDto> createEducation( @RequestBody  EducationDto educationDto){
        EducationDto savedEducationDto=   educationService.createEducation(educationDto);
        return new ResponseEntity<>(savedEducationDto, HttpStatus.CREATED);
    }

    //Get education details specific id
    @GetMapping("/education/{id}")
    public ResponseEntity<EducationDto>getEducationById(@PathVariable int id){
         EducationDto educationDto=  educationService.getEducationById(id);
         return ResponseEntity.ok(educationDto);
    }


    //GetAll educations
    @GetMapping("/education")
    public ResponseEntity<List<EducationDto>> getAllEducations(){
        List<EducationDto>educationDtos=educationService.getAllEducations();
        return ResponseEntity.ok(educationDtos);
    }

    // update Educations
    @PutMapping("/education/{id}")
    public ResponseEntity<EducationDto> updateEducations(@PathVariable int id, @RequestBody EducationDto educationDto){
        EducationDto updateEducationDto=educationService.updateEducations(id,educationDto);
        return ResponseEntity.ok(updateEducationDto);
    }

    // Delete Education Details
    @DeleteMapping("/education/{id}")
    public ResponseEntity<String> deleteEducations(@PathVariable int id){
         educationService.deleteEducationDetails(id);
         return ResponseEntity.ok("deleted educations");
    }

}
