package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.ImageDto;
import com.funeralAPI.backendAPI.entity.Image;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.ImageMapper;
import com.funeralAPI.backendAPI.repository.ImageRepository;
import com.funeralAPI.backendAPI.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private  ImageRepository imageRepository;

    @Override
    public ImageDto createImage(ImageDto imageDto) {
        Image image = ImageMapper.mapToImage(imageDto);
        Image savedImage = imageRepository.save(image);
        return ImageMapper.mapToImageDto(savedImage);
    }

    @Override
    public ImageDto getImageById(int id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return ImageMapper.mapToImageDto(image);
    }

    @Override
    public List<ImageDto> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return images.stream()
                .map(ImageMapper::mapToImageDto)
                .collect(Collectors.toList());
    }

    @Override
    public ImageDto updateImage(int id, ImageDto imageDto) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));

        // Update image fields from the provided ImageDto
        image.setPerson_id(imageDto.getPerson_id());
        image.setPhoto(imageDto.getPhoto());
        image.setMemorial(imageDto.getMemorial());
        image.setBackground_image(imageDto.getBackground_image());

        // Save the updated image
        Image updatedImage = imageRepository.save(image);

        // Map the updated image to ImageDto and return
        return ImageMapper.mapToImageDto(updatedImage);
    }

    @Override
    public void deleteImage(int id) {
        if (!imageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
        imageRepository.deleteById(id);
    }
}
