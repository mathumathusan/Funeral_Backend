package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.AboutDto;
import com.funeralAPI.backendAPI.entity.About;

public class AboutMapper {
    public static About mapToAbout(AboutDto aboutDto){
        return new About(
                aboutDto.getAbout_id(),
                aboutDto.getPerson_id(),
                aboutDto.getAbout_name(),
                aboutDto.getAbout_relationship(),
                aboutDto.getAbout_mobile_number(),
                aboutDto.getAbout_email(),
                aboutDto.getIsTerm()
        );
    }

    public static AboutDto mapToAboutDto(About about){
        return new AboutDto(
                about.getAbout_id(),
                about.getPerson_id(),
                about.getAbout_name(),
                about.getAbout_relationship(),
                about.getAbout_mobile_number(),
                about.getAbout_email(),
                about.getIsTerm()
        );
    }
}
