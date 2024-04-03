package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.PersonDto;

import java.util.List;

public interface PersonService {


PersonDto createPerson(PersonDto personDto);

PersonDto getPersonById(Integer id);

List<PersonDto> getAllPersons();

PersonDto updatePerson(int id, PersonDto personDto);

void deletePerson(int id);

}
