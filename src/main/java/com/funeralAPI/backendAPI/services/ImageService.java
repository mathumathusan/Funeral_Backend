package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.ImageDto;
import java.util.List;

public interface ImageService {

    ImageDto createImage(ImageDto imageDto);

    ImageDto getImageById(int id);

    List<ImageDto> getAllImages();

    ImageDto updateImage(int id, ImageDto imageDto);

    void deleteImage(int id);
}
