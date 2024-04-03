package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.StoryDto;
import java.util.List;

public interface StoryService {

    StoryDto createStory(StoryDto storyDto);

    StoryDto getStoryById(int id);

    List<StoryDto> getAllStories();

    StoryDto updateStory(int id, StoryDto storyDto);

    void deleteStory(int id);
}
