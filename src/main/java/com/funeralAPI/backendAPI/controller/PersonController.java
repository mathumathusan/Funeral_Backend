package com.funeralAPI.backendAPI.controller;


import com.funeralAPI.backendAPI.dto.PersonDto;
import com.funeralAPI.backendAPI.entity.Person;
import com.funeralAPI.backendAPI.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class PersonController {


    PersonService personService;

    // post persons details
    @PostMapping("/person")
    public ResponseEntity<PersonDto>  createPersons(@RequestBody  PersonDto personDto){
       PersonDto savedPersonDto= personService.createPerson(personDto);
       return  new ResponseEntity<>(savedPersonDto, HttpStatus.CREATED);
    }

    //get person with specific id
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable int id){
        PersonDto personDto =personService.getPersonById(id);
        return ResponseEntity.ok(personDto);
    }

    //Get all the Persons
    @GetMapping("/person")
    public ResponseEntity<List <PersonDto>> getAllPersons(){
        List<PersonDto> personDtos=personService.getAllPersons();
        return ResponseEntity.ok(personDtos);
    }

    //Update the Persons
    @PutMapping("/person/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable int id,@RequestBody PersonDto personDto){
        PersonDto updatedPersonDto=personService.updatePerson(id,personDto);
        return ResponseEntity.ok(updatedPersonDto);
    }

    //Delete the persons
    @DeleteMapping("/person/{id}")
    public ResponseEntity<String> deletePersons(@PathVariable int id){
        personService.deletePerson(id);
        return ResponseEntity.ok("deleted the persons");
    }



}
