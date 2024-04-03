package com.funeralAPI.backendAPI.controller;

import com.funeralAPI.backendAPI.dto.StoryDto;
import com.funeralAPI.backendAPI.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class StoryController {

     StoryService storyService;

    // Endpoint to create a story
    @PostMapping("/story")
    public ResponseEntity<StoryDto> createStory(@RequestBody StoryDto storyDto) {
        StoryDto savedStoryDto = storyService.createStory(storyDto);
        return new ResponseEntity<>(savedStoryDto, HttpStatus.CREATED);
    }

    // Endpoint to get a story by ID
    @GetMapping("/story/{id}")
    public ResponseEntity<StoryDto> getStoryById(@PathVariable int id) {
        StoryDto storyDto = storyService.getStoryById(id);
        return ResponseEntity.ok(storyDto);
    }

    // Endpoint to get all stories
    @GetMapping("/story")
    public ResponseEntity<List<StoryDto>> getAllStories() {
        List<StoryDto> stories = storyService.getAllStories();
        return ResponseEntity.ok(stories);
    }

    // Endpoint to update a story by ID
    @PutMapping("/story/{id}")
    public ResponseEntity<StoryDto> updateStory(@PathVariable int id, @RequestBody StoryDto storyDto) {
        StoryDto updatedStoryDto = storyService.updateStory(id, storyDto);
        return ResponseEntity.ok(updatedStoryDto);
    }

    // Endpoint to delete a story by ID
    @DeleteMapping("/story/{id}")
    public ResponseEntity<String> deleteStory(@PathVariable int id) {
        storyService.deleteStory(id);
        return ResponseEntity.ok("Story with id " + id + " deleted successfully");
    }
}
