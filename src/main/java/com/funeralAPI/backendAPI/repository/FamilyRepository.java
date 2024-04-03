package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamilyRepository extends JpaRepository<Family,Integer> {
    @Query("SELECT f FROM Family f WHERE f.person_id = :personId")
    Family findByPersonId(@Param("personId") int personId);


}
