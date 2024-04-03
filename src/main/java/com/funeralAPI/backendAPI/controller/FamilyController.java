package com.funeralAPI.backendAPI.controller;


import com.funeralAPI.backendAPI.dto.FamilyDto;
import com.funeralAPI.backendAPI.entity.Family;
import com.funeralAPI.backendAPI.services.FamilyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funeral")
@AllArgsConstructor
public class FamilyController {
    FamilyService familyService;


    // post the family in the database
    @PostMapping("/family")
    public ResponseEntity<FamilyDto> createFamily(@RequestBody FamilyDto familyDto){
        FamilyDto savedFamilyDto=familyService.createFamily(familyDto);
        return new ResponseEntity<>(savedFamilyDto, HttpStatus.CREATED);
    }

    //fetch the family with specific id
    @GetMapping("/family/{id}")
    public ResponseEntity<FamilyDto> getFamilyById(@PathVariable int id){
         FamilyDto familyDto=familyService.getFamilyById(id);
         return ResponseEntity.ok(familyDto);
    }

    //get All Families Lists
    @GetMapping("/family")
    public ResponseEntity<List<FamilyDto>> getAllFamily(){
        List<FamilyDto> families=familyService.getAllFamily();
        return ResponseEntity.ok(families);
    }

    // update family with specific id
    @PutMapping("/family/{id}")
    public ResponseEntity<FamilyDto> updateFamily(@PathVariable int id, @RequestBody FamilyDto familydto){
        FamilyDto updatedFamiyDto=familyService.updateFamily(id, familydto);
        return ResponseEntity.ok(updatedFamiyDto);
    }

    //Delete family details by id
    @DeleteMapping("/family/{id}")
    public ResponseEntity<String> deleteFamilyByID(@PathVariable int id){
         familyService.deleteFamily(id);
         return ResponseEntity.ok("deleted family");
    }


}
