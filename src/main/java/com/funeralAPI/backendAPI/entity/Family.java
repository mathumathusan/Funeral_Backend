package com.funeralAPI.backendAPI.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int family_id;
    private int person_id;
    private String full_name;
    private String relationship;
    private String prefull_name;
    private String prerelationship;
    private String mobile_number;
    private  boolean is_predeceased;
}
