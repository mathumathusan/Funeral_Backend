package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.ImageDto;
import com.funeralAPI.backendAPI.entity.Image;

public class ImageMapper {
    public static Image mapToImage(ImageDto imageDto){
        return new Image(
                imageDto.getImage_id(),
                imageDto.getPerson_id(),
                imageDto.getPhoto(),
                imageDto.getMemorial(),
                imageDto.getBackground_image()
        );
    }

    public static ImageDto mapToImageDto(Image image){
        return new ImageDto(
                image.getImage_id(),
                image.getPerson_id(),
                image.getPhoto(),
                image.getMemorial(),
                image.getBackground_image()
        );
    }
}
