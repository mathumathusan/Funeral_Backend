package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.FamilyDto;
import com.funeralAPI.backendAPI.dto.FormDto;
import com.funeralAPI.backendAPI.entity.*;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.FamilyMapper;
import com.funeralAPI.backendAPI.mapper.PersonMapper;
import com.funeralAPI.backendAPI.repository.*;
import com.funeralAPI.backendAPI.services.FormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FormServiceImpl implements FormService {

    PersonRepository personRepository;
    EducationRepository educationRepository;
    FamilyRepository familyRepository;
    ContactRepository contactRepository;
    EventRepository eventRepository;
    ImageRepository imageRepository;
    StoryRepository storyRepository;
    AboutRepository aboutRepository;
    CategoryRepository categoryRepository;

    @Override
    public FormDto createForm(FormDto formDto) {

           //add persons
        Person person = new Person();
        person.setPerson_id(formDto.getPerson_id());
        person.setFirst_name(formDto.getFirst_name());
        person.setLast_name(formDto.getLast_name());
        person.setNickname(formDto.getNickname());
        person.setGender(formDto.getGender());
        person.setDate_of_birth(formDto.getDate_of_birth());
        person.setPlace(formDto.getPlace());
        person.setPlace_of_birth_city(formDto.getPlace_of_birth_city());
        person.setPlace_of_birth_country(formDto.getPlace_of_birth_country());
        person.setDate_of_death(formDto.getDate_of_death());
        person.setAge_at_death(formDto.getAge_at_death());
        person.setPlace_of_death_city(formDto.getPlace_of_death_city());
        person.setPlace_of_death_country(formDto.getPlace_of_death_country());
        person.setOccupation(formDto.getOccupation());
        person.setFuneral_date(formDto.getFuneral_date());
        person.setFuneral_start_time(formDto.getFuneral_start_time());
        person.setFuneral_end_time(formDto.getFuneral_end_time());
        person.setFuneral_home_address(formDto.getFuneral_home_address());
        person.setVirtual_service_url(formDto.getVirtual_service_url());

      Person savedPerson=  personRepository.save(person);

        // ADD Family

        Family family= new Family();
//        family.setFamily_id(formDto.getFamily_id());
        family.setPerson_id(formDto.getPerson_id());
        family.setFull_name(formDto.getFull_name());
        family.setRelationship(formDto.getRelationship());
        family.setPrefull_name(formDto.getPrefull_name());
        family.setPrerelationship(formDto.getPrerelationship());
        family.setMobile_number(formDto.getMobile_number());

        Family savedFamily =familyRepository.save(family);

        //Add Education

        Education education=new Education();
//        education.setEducation_id(formDto.getEducation_id());
        education.setPerson_id(formDto.getPerson_id());
        education.setPrimary_school(formDto.getPrimary_school());
        education.setHigh_school(formDto.getHigh_school());
        education.setCollege(formDto.getCollege());


        educationRepository.save(education);

        //Add contact

        Contact contact = new Contact();
//        contact.setContact_id(formDto.getContact_id());
        contact.setPerson_id(formDto.getPerson_id());
        contact.setContact_name(formDto.getContact_name());
        contact.setContact_relationship(formDto.getContact_relationship());
        contact.setContact_mobile_number(formDto.getContact_mobile_number());

        contactRepository.save(contact);

        //Add event
        Event event=new Event();
//        event.setEvent_id(formDto.getEvent_id());
        event.setPerson_id(formDto.getPerson_id());
        event.setEvent_type(formDto.getEvent_type());
        event.setEvent_date(formDto.getEvent_date());
        event.setEvent_start_time(formDto.getEvent_start_time());
        event.setEvent_end_time(formDto.getEvent_end_time());
        event.setEvent_address(formDto.getEvent_address());
        eventRepository.save(event);

        //Add Image
        Image image = new Image();


//        image.setImage_id(formDto.getImage_id());
        image.setPerson_id(formDto.getPerson_id());
        image.setPhoto(formDto.getPhoto());
        image.setMemorial(formDto.getMemorial());
        image.setBackground_image(formDto.getBackground_image());

        imageRepository.save(image);

        //Add Story
        Story story=new Story();
//        story.setStory_id(formDto.getStory_id());
        story.setPerson_id(formDto.getPerson_id());
        story.setDescription(formDto.getDescription());

        storyRepository.save(story);

        // Add Category
        Category category = new Category();
//        category.setCategory_id(formDto.getCategory_id());
        category.setPerson_id(formDto.getPerson_id());
        category.setCategory(formDto.getCategory());

        categoryRepository.save(category);

        //Add About
        About about=new About();
        about.setPerson_id(formDto.getPerson_id());
//        about.setAbout_id(formDto.getAbout_id());
        about.setAbout_email(formDto.getAbout_email());
        about.setAbout_name(formDto.getAbout_name());
        about.setAbout_relationship(formDto.getAbout_relationship());
        about.setIsTerm(formDto.getIsTerm());
        about.setAbout_mobile_number(formDto.getAbout_mobile_number());


        aboutRepository.save(about);
        return formDto;
    }

    @Override
    public FormDto updateForm(int id,FormDto formDto) {

        Person person=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found"));
        Family family= familyRepository.findByPersonId(id);
        Image image=imageRepository.findByPersonId(id);
        Story story=storyRepository.findByPersonId(id);
        Event event=eventRepository.findByPersonId(id);
        Education education=educationRepository.findByPersonId(id);
        Contact contact=contactRepository.findByPersonId(id);
        Category category=categoryRepository.findByPersonId(id);
        About about=aboutRepository.findByPersonId(id);


        if (person != null) {
            person.setFirst_name(formDto.getFirst_name());
            person.setLast_name(formDto.getLast_name());
            person.setNickname(formDto.getNickname());
            person.setGender(formDto.getGender());
            person.setDate_of_birth(formDto.getDate_of_birth());
            person.setPlace(formDto.getPlace());
            person.setPlace_of_birth_city(formDto.getPlace_of_birth_city());
            person.setPlace_of_birth_country(formDto.getPlace_of_birth_country());
            person.setDate_of_death(formDto.getDate_of_death());
            person.setAge_at_death(formDto.getAge_at_death());
            person.setPlace_of_death_city(formDto.getPlace_of_death_city());
            person.setPlace_of_death_country(formDto.getPlace_of_death_country());
            person.setOccupation(formDto.getOccupation());
            person.setFuneral_date(formDto.getFuneral_date());
            person.setFuneral_start_time(formDto.getFuneral_start_time());
            person.setFuneral_end_time(formDto.getFuneral_end_time());
            person.setFuneral_home_address(formDto.getFuneral_home_address());
            person.setVirtual_service_url(formDto.getVirtual_service_url());
        } else {
            throw new ResourceNotFoundException("Person not found");
        }

        if (family != null) {
            family.setFull_name(formDto.getFull_name());
            family.setRelationship(formDto.getRelationship());
            family.setPrefull_name(formDto.getPrefull_name());
            family.setPrerelationship(formDto.getPrerelationship());
            family.setMobile_number(formDto.getMobile_number());
        }

        if (image != null) {
            image.setPhoto(formDto.getPhoto());
            image.setMemorial(formDto.getMemorial());
            image.setBackground_image(formDto.getBackground_image());
        }

        if (story != null) {
            story.setDescription(formDto.getDescription());
        }

        if (event != null) {
            event.setEvent_type(formDto.getEvent_type());
            event.setEvent_date(formDto.getEvent_date());
            event.setEvent_start_time(formDto.getEvent_start_time());
            event.setEvent_end_time(formDto.getEvent_end_time());
            event.setEvent_address(formDto.getEvent_address());
        }

        if (education != null) {
            education.setPrimary_school(formDto.getPrimary_school());
            education.setHigh_school(formDto.getHigh_school());
            education.setCollege(formDto.getCollege());
        }

        if (contact != null) {
            contact.setContact_name(formDto.getContact_name());
            contact.setContact_relationship(formDto.getContact_relationship());
            contact.setContact_mobile_number(formDto.getContact_mobile_number());
        }

        if (category != null) {
            category.setCategory(formDto.getCategory());
        }

        if (about != null) {
            about.setAbout_email(formDto.getAbout_email());
            about.setAbout_name(formDto.getAbout_name());
            about.setAbout_relationship(formDto.getAbout_relationship());
            about.setIsTerm(formDto.getIsTerm());
            about.setAbout_mobile_number(formDto.getAbout_mobile_number());
        }


        // Save the updated entities
        personRepository.save(person);
        familyRepository.save(family);
        imageRepository.save(image);
        storyRepository.save(story);
        eventRepository.save(event);
        educationRepository.save(education);
        contactRepository.save(contact);
        categoryRepository.save(category);
        aboutRepository.save(about);


        return formDto;
    }

    @Override
    public void deleteForm(int id) {

        Person person=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("person not found"));
        Family family= familyRepository.findByPersonId(id);
        Image image=imageRepository.findByPersonId(id);
        Story story=storyRepository.findByPersonId(id);
        Event event=eventRepository.findByPersonId(id);
        Education education=educationRepository.findByPersonId(id);
        Contact contact=contactRepository.findByPersonId(id);
        Category category=categoryRepository.findByPersonId(id);
        About about=aboutRepository.findByPersonId(id);


        personRepository.deleteById(id);
        familyRepository.deleteById(family.getFamily_id());
        imageRepository.deleteById(image.getImage_id());
        storyRepository.deleteById(story.getStory_id());
        eventRepository.deleteById(event.getEvent_id());
        educationRepository.deleteById(education.getEducation_id());
        contactRepository.deleteById(contact.getContact_id());
        categoryRepository.deleteById(category.getCategory_id());
        aboutRepository.deleteById(about.getAbout_id());

    }


}
