package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.StoryDto;
import com.funeralAPI.backendAPI.entity.Story;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.StoryMapper;
import com.funeralAPI.backendAPI.repository.StoryRepository;
import com.funeralAPI.backendAPI.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StoryServiceImpl implements StoryService {

     StoryRepository storyRepository;

    @Override
    public StoryDto createStory(StoryDto storyDto) {
        Story story = StoryMapper.mapToStory(storyDto);
        Story savedStory = storyRepository.save(story);
        return StoryMapper.mapToStoryDto(savedStory);
    }

    @Override
    public StoryDto getStoryById(int id) {
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Story not found with id: " + id));
        return StoryMapper.mapToStoryDto(story);
    }

    @Override
    public List<StoryDto> getAllStories() {
        List<Story> stories = storyRepository.findAll();
        return stories.stream()
                .map(StoryMapper::mapToStoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public StoryDto updateStory(int id, StoryDto storyDto) {
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Story not found with id: " + id));

        // Update story fields from the provided StoryDto
        story.setPerson_id(storyDto.getPerson_id());
        story.setDescription(storyDto.getDescription());

        // Save the updated story
        Story updatedStory = storyRepository.save(story);

        // Map the updated story to StoryDto and return
        return StoryMapper.mapToStoryDto(updatedStory);
    }

    @Override
    public void deleteStory(int id) {
        if (!storyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Story not found with id: " + id);
        }
        storyRepository.deleteById(id);
    }
}
