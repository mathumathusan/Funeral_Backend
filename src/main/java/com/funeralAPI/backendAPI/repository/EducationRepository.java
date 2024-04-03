package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    @Query("SELECT a FROM Education a WHERE a.person_id = :personId")
    Education findByPersonId(@Param("personId") int personId);
}
