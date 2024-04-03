package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.AboutDto;

import java.util.List;

public interface AboutService {

    AboutDto createAbout(AboutDto aboutDto);

    AboutDto getAboutById(int id);

    AboutDto updateAbout(int id, AboutDto aboutDto);

    List<AboutDto> getAllAbouts();

    void deleteAbout(int id);
}
