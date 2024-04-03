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
@Table(name = "story")
public class Story {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int story_id;
    private int person_id;
    private String description;

}
