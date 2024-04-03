package com.funeralAPI.backendAPI.controller;

import com.funeralAPI.backendAPI.dto.ContactDto;
import com.funeralAPI.backendAPI.dto.PersonDto;
import com.funeralAPI.backendAPI.services.ContactService;
import com.funeralAPI.backendAPI.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class ContactController {
    ContactService contactService;

    // post contacts details
    @PostMapping("/contact")
    public ResponseEntity<ContactDto> createContacts(@RequestBody ContactDto contactDto){
        ContactDto savedContactDto= contactService.createContact(contactDto);
        return  new ResponseEntity<>(savedContactDto, HttpStatus.CREATED);
    }

    //get contact with specific id
    @GetMapping("/contact/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable int id){
        ContactDto contactDto =contactService.getContactById(id);
        return ResponseEntity.ok(contactDto);
    }

    //Get all the Contacts
    @GetMapping("/contact")
    public ResponseEntity<List<ContactDto>> getAllContacts(){
        List<ContactDto> contact=contactService.getAllContacts();
        return ResponseEntity.ok(contact);
    }

    //Update the Contacts
    @PutMapping("/contact/{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable int id,@RequestBody ContactDto contactDto){
        ContactDto updatedContactDto=contactService.updateContacts(id,contactDto);
        return ResponseEntity.ok(updatedContactDto);
    }

    //Delete the contacts
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<String> deleteContacts(@PathVariable int id){
        contactService.deleteContactDetails(id);
        return ResponseEntity.ok("deleted the contacts");
    }
}
