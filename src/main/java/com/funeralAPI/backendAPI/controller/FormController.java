package com.funeralAPI.backendAPI.controller;


import com.funeralAPI.backendAPI.dto.FormDto;
import com.funeralAPI.backendAPI.services.FormService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/funeral")
public class FormController {

    FormService formService;


    // post all data in multiple tables single api
    @PostMapping("/form")
    public ResponseEntity<FormDto> createForm(@RequestBody FormDto formDto){
                FormDto savedFormDto=formService.createForm(formDto);
                return new ResponseEntity<>(savedFormDto, HttpStatus.CREATED);
    }

    //edit all data in multiple tables in single api

    @PutMapping("/form/{id}")
    public ResponseEntity<FormDto> updateForm(@PathVariable int id,@RequestBody FormDto formDto){
      FormDto formDto1=  formService.updateForm(id,formDto);
                return ResponseEntity.ok(formDto1);
    }

    //delete all data in multiple tables in single api
    @DeleteMapping("/form/{id}")
    public ResponseEntity<String> deleteForm(@PathVariable int id){
        formService.deleteForm(id);
        return ResponseEntity.ok("deleted all data");
    }

}
