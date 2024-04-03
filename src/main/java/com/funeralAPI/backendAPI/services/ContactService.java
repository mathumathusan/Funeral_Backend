package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.ContactDto;
import com.funeralAPI.backendAPI.dto.EducationDto;

import java.util.List;

public interface ContactService {

    ContactDto createContact(ContactDto contactDto);

    ContactDto getContactById(int id);

    List<ContactDto> getAllContacts();

    ContactDto updateContacts(int id,ContactDto contactDto);

    void deleteContactDetails(int id);

}
