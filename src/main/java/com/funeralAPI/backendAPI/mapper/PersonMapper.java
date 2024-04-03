package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.PersonDto;
import com.funeralAPI.backendAPI.entity.Person;

public class PersonMapper {

public static PersonDto mapToPersonDto(Person person){
    return new PersonDto(
            person.getPerson_id(),
            person.getFirst_name(),
            person.getLast_name(),
            person.getGender(),
            person.getNickname(),
            person.getDate_of_birth(),
            person.getPlace(),
            person.getPlace_of_birth_city(),
            person.getPlace_of_birth_country(),
            person.getDate_of_death(),
            person.getAge_at_death(),
            person.getPlace_of_death_city(),
            person.getPlace_of_death_country(),
            person.getOccupation(),
            person.getFuneral_date(),
            person.getFuneral_start_time(),
            person.getFuneral_end_time(),
            person.getFuneral_home_address(),
            person.getVirtual_service_url());
}

    public static Person mapToPerson(PersonDto personDto){
        return new Person(
                personDto.getPerson_id(),
                personDto.getFirst_name(),
                personDto.getLast_name(),
                personDto.getGender(),
                personDto.getNickname(),
                personDto.getDate_of_birth(),
                personDto.getPlace(),
                personDto.getPlace_of_birth_city(),
                personDto.getPlace_of_birth_country(),
                personDto.getDate_of_death(),
                personDto.getAge_at_death(),
                personDto.getPlace_of_death_city(),
                personDto.getPlace_of_death_country(),
                personDto.getOccupation(),
                personDto.getFuneral_date(),
                personDto.getFuneral_start_time(),
                personDto.getFuneral_end_time(),
                personDto.getFuneral_home_address(),
                personDto.getVirtual_service_url());
    }





}
