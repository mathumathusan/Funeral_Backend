package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.ContactDto;
import com.funeralAPI.backendAPI.dto.PersonDto;
import com.funeralAPI.backendAPI.entity.Contact;
import com.funeralAPI.backendAPI.entity.Person;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.ContactMapper;
import com.funeralAPI.backendAPI.mapper.PersonMapper;
import com.funeralAPI.backendAPI.repository.ContactRepository;
import com.funeralAPI.backendAPI.repository.PersonRepository;
import com.funeralAPI.backendAPI.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact= ContactMapper.mapToContact(contactDto);
        Contact savedContact = contactRepository.save(contact);
        return ContactMapper.mapToContactDto(savedContact);
    }

    @Override
    public ContactDto getContactById(int id) {

        Contact contact= contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found"));

        return ContactMapper.mapToContactDto(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {

        List<Contact> contacts= contactRepository.findAll();
        return contacts.stream().map((contact)->ContactMapper.mapToContactDto(contact)).collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContacts(int id, ContactDto contactDto) {

        Contact contact= contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found with"+id));
        contact.setContact_id(contactDto.getContact_id());
        contact.setPerson_id(contactDto.getPerson_id());
        contact.setContact_name(contactDto.getContact_name());
        contact.setContact_relationship(contactDto.getContact_relationship());
        contact.setContact_mobile_number(contactDto.getContact_mobile_number());


        Contact updatedContact=contactRepository.save(contact);


        return ContactMapper.mapToContactDto(updatedContact);

    }

    @Override
    public void deleteContactDetails(int id) {
        Contact contact=  contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found with specific id"+id));
        contactRepository.deleteById(id);
    }
}

