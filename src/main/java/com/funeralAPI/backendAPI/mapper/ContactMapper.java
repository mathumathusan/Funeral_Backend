package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.ContactDto;
import com.funeralAPI.backendAPI.entity.Contact;

public class ContactMapper {
    public static Contact mapToContact(ContactDto contactDto){
        return new Contact(
                contactDto.getContact_id(),
                contactDto.getPerson_id(),
                contactDto.getContact_name(),
                contactDto.getContact_relationship(),
                contactDto.getContact_mobile_number()
        );
    }

    public static ContactDto mapToContactDto(Contact contact){
        return new ContactDto(
                contact.getContact_id(),
                contact.getPerson_id(),
                contact.getContact_name(),
                contact.getContact_relationship(),
                contact.getContact_mobile_number()
        );
    }
}
