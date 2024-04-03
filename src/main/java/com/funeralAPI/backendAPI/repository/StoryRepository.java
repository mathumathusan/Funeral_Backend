package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoryRepository extends JpaRepository<Story,Integer> {
    @Query("SELECT a FROM Story a WHERE a.person_id = :personId")
    Story findByPersonId(@Param("personId") int personId);
}
