package com.funeralAPI.backendAPI.controller;

import com.funeralAPI.backendAPI.dto.AboutDto;
import com.funeralAPI.backendAPI.services.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/funeral")
public class AboutController {
 AboutService aboutService;

    // Post about details
    @PostMapping("/about")
    public ResponseEntity<AboutDto> createAbout(@RequestBody AboutDto aboutDto) {
        AboutDto savedAboutDto = aboutService.createAbout(aboutDto);
        return new ResponseEntity<>(savedAboutDto, HttpStatus.CREATED);
    }

    // Get about with specific id
    @GetMapping("/about/{id}")
    public ResponseEntity<AboutDto> getAboutById(@PathVariable int id) {
        AboutDto aboutDto = aboutService.getAboutById(id);
        return ResponseEntity.ok(aboutDto);
    }

    // Get all the Abouts
    @GetMapping("/about")
    public ResponseEntity<List<AboutDto>> getAllAbouts() {
        List<AboutDto> abouts = aboutService.getAllAbouts();
        return ResponseEntity.ok(abouts);
    }

    // Update the Abouts
    @PutMapping("/about/{id}")
    public ResponseEntity<AboutDto> updateAbout(@PathVariable int id, @RequestBody AboutDto aboutDto) {
        AboutDto updatedAboutDto = aboutService.updateAbout(id, aboutDto);
        return ResponseEntity.ok(updatedAboutDto);
    }

    // Delete the Abouts
    @DeleteMapping("/about/{id}")
    public ResponseEntity<String> deleteAbout(@PathVariable int id) {
        aboutService.deleteAbout(id);
        return ResponseEntity.ok("Deleted the About");
    }
}
