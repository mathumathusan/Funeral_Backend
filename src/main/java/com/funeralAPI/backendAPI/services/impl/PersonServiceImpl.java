package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.PersonDto;
import com.funeralAPI.backendAPI.entity.Person;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.PersonMapper;
import com.funeralAPI.backendAPI.repository.PersonRepository;
import com.funeralAPI.backendAPI.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {


    private PersonRepository personRepository;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
         Person Person=PersonMapper.mapToPerson(personDto);
         Person savedPerson = personRepository.save(Person);
         return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPersonById(Integer id) {

       Person person= personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found"));

        return PersonMapper.mapToPersonDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {

        List<Person> persons= personRepository.findAll();
        return persons.stream().map((person)->PersonMapper.mapToPersonDto(person)).collect(Collectors.toList());
    }

    @Override
    public PersonDto updatePerson(int id, PersonDto personDto) {

       Person person= personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found with"+id));
        person.setPerson_id(personDto.getPerson_id());
        person.setFirst_name(personDto.getFirst_name());
        person.setLast_name(personDto.getLast_name());
        person.setNickname(personDto.getNickname());
        person.setGender(personDto.getGender());
        person.setDate_of_birth(personDto.getDate_of_birth());
        person.setPlace(personDto.getPlace());
        person.setPlace_of_birth_city(personDto.getPlace_of_birth_city());
        person.setPlace_of_birth_country(personDto.getPlace_of_birth_country());
        person.setDate_of_death(personDto.getDate_of_death());
        person.setAge_at_death(personDto.getAge_at_death());
        person.setPlace_of_death_city(personDto.getPlace_of_death_city());
        person.setPlace_of_death_country(personDto.getPlace_of_death_country());
        person.setOccupation(personDto.getOccupation());
        person.setFuneral_date(personDto.getFuneral_date());
        person.setFuneral_start_time(personDto.getFuneral_start_time());
        person.setFuneral_end_time(personDto.getFuneral_end_time());
        person.setFuneral_home_address(personDto.getFuneral_home_address());
        person.setVirtual_service_url(personDto.getVirtual_service_url());

        Person updatedPerson=personRepository.save(person);


        return PersonMapper.mapToPersonDto(updatedPerson);

    }

    @Override
    public void deletePerson(int id) {
      Person person=  personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found with specific id"+id));
      personRepository.deleteById(id);
    }
}
