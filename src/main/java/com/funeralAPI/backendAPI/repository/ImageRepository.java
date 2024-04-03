package com.funeralAPI.backendAPI.repository;

import com.funeralAPI.backendAPI.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    @Query("SELECT a FROM Image a WHERE a.person_id = :personId")
    Image findByPersonId(@Param("personId") int personId);
}
