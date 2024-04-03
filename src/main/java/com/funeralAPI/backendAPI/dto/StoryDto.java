package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoryDto {
    private int story_id;
    private int person_id;
    private String description;
}
