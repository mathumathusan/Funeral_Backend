package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT a FROM Event a WHERE a.person_id = :personId")
    Event findByPersonId(@Param("personId") int personId);
}
