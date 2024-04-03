package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private int image_id;
    private int person_id;
    private String photo;
    private String memorial;
    private String background_image;
}
