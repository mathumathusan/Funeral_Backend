package com.funeralAPI.backendAPI.repository;


import com.funeralAPI.backendAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("SELECT a FROM Category a WHERE a.person_id = :personId")
    Category findByPersonId(@Param("personId") int personId);
}
