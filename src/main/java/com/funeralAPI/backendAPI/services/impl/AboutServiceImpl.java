package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.AboutDto;
import com.funeralAPI.backendAPI.entity.About;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.AboutMapper;
import com.funeralAPI.backendAPI.repository.AboutRepository;
import com.funeralAPI.backendAPI.services.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService {
    AboutRepository aboutRepository;

    @Override
    public AboutDto createAbout(AboutDto aboutDto) {
        About about = AboutMapper.mapToAbout(aboutDto);
        About savedAbout = aboutRepository.save(about);
        return AboutMapper.mapToAboutDto(savedAbout);
    }

    @Override
    public AboutDto getAboutById(int id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with id: " + id));
        return AboutMapper.mapToAboutDto(about);
    }

    @Override
    public List<AboutDto> getAllAbouts() {
        List<About> abouts = aboutRepository.findAll();
        return abouts.stream()
                .map(AboutMapper::mapToAboutDto)
                .collect(Collectors.toList());
    }

    @Override
    public AboutDto updateAbout(int id, AboutDto aboutDto) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with id: " + id));

        // Update about fields from the provided AboutDto
        about.setPerson_id(aboutDto.getPerson_id());
        about.setAbout_name(aboutDto.getAbout_name());
        about.setAbout_relationship(aboutDto.getAbout_relationship());
        about.setAbout_mobile_number(aboutDto.getAbout_mobile_number());
        about.setAbout_email(aboutDto.getAbout_email());
        about.setIsTerm(aboutDto.getIsTerm());

        // Save the updated about
        About updatedAbout = aboutRepository.save(about);

        // Map the updated about to AboutDto and return
        return AboutMapper.mapToAboutDto(updatedAbout);
    }

    @Override
    public void deleteAbout(int id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with id: " + id));
        aboutRepository.deleteById(id);
    }
}
