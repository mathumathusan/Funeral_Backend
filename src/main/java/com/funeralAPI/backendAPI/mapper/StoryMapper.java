package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.StoryDto;
import com.funeralAPI.backendAPI.entity.Story;

public class StoryMapper {

        public static Story mapToStory(StoryDto storyDto){
            return new Story(
                    storyDto.getStory_id(),
                    storyDto.getPerson_id(),
                    storyDto.getDescription()
            );
        }

        public static StoryDto mapToStoryDto(Story story){
            return new StoryDto(
                    story.getStory_id(),
                    story.getPerson_id(),
                    story.getDescription()
            );
        }
}
