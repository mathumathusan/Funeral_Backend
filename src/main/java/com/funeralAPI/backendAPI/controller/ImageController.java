package com.funeralAPI.backendAPI.controller;

import com.funeralAPI.backendAPI.dto.ImageDto;
import com.funeralAPI.backendAPI.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class ImageController {

     ImageService imageService;

    // Endpoint to create an image
    @PostMapping("/image")
    public ResponseEntity<ImageDto> createImage(@RequestBody ImageDto imageDto) {
        ImageDto savedImageDto = imageService.createImage(imageDto);
        return new ResponseEntity<>(savedImageDto, HttpStatus.CREATED);
    }

    // Endpoint to get an image by ID
    @GetMapping("/image/{id}")
    public ResponseEntity<ImageDto> getImageById(@PathVariable int id) {
        ImageDto imageDto = imageService.getImageById(id);
        return ResponseEntity.ok(imageDto);
    }

    // Endpoint to get all images
    @GetMapping("/image")
    public ResponseEntity<List<ImageDto>> getAllImages() {
        List<ImageDto> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    // Endpoint to update an image by ID
    @PutMapping("/image/{id}")
    public ResponseEntity<ImageDto> updateImage(@PathVariable int id, @RequestBody ImageDto imageDto) {
        ImageDto updatedImageDto = imageService.updateImage(id, imageDto);
        return ResponseEntity.ok(updatedImageDto);
    }

    // Endpoint to delete an image by ID
    @DeleteMapping("/image/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable int id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("Image with id " + id + " deleted successfully");
    }
}
