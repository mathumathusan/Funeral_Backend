package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    @Query("SELECT a FROM Contact a WHERE a.person_id = :personId")
    Contact findByPersonId(@Param("personId") int personId);
}
