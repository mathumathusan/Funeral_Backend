package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.About;
import com.funeralAPI.backendAPI.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AboutRepository extends JpaRepository<About,Integer> {

    @Query("SELECT a FROM About a WHERE a.person_id = :personId")
    About findByPersonId(@Param("personId") int personId);

}
