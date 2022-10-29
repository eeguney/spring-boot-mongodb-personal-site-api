package com.emreguney.personalsite.controllers;

import com.emreguney.personalsite.domain.Experience;
import com.emreguney.personalsite.exception.DataIsNotValidException;
import com.emreguney.personalsite.exception.NotFoundException;
import com.emreguney.personalsite.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = experienceService.getExperiences();
        return ResponseEntity.ok().body(experiences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Experience>> getAnExperience(@PathVariable Long id) throws NotFoundException {
        Optional<Experience> experience = experienceService.getExperienceById(id);
        if (experience.isEmpty()) {
            throw new NotFoundException("There is no experience item with this Id");
        }
        return ResponseEntity.ok().body(experience);

    }

    @PostMapping("/")
    public ResponseEntity<Experience> save(@Valid @RequestBody Experience experience) throws DataIsNotValidException {
        try {
            Experience newExperience = experienceService.updateOrCreate(experience);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/experience").toUriString());
            return ResponseEntity.created(uri).body(newExperience);
        } catch (ConstraintViolationException e) {
            throw new DataIsNotValidException("Data is not valid:" + e.getMessage());
        }
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Experience>> saveMultipleExperience(@Valid @RequestBody List<Experience> experiences) throws DataIsNotValidException {
        try {
            List<Experience> newExperiences = experienceService.multipleUpdateOrCreate(experiences);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/experience/multiple").toUriString());
            return ResponseEntity.created(uri).body(newExperiences);
        } catch (ConstraintViolationException e) {
            throw new DataIsNotValidException("Data is not valid: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnExperienceWithId(@PathVariable Long id) throws NotFoundException {
        Optional<Experience> thatExperience = experienceService.getExperienceById(id);
        if (thatExperience.isEmpty()) {
            throw new NotFoundException("There is no experience with this Id: ");
        }
        experienceService.deleteAnExperienceWithId(id);
        return ResponseEntity.ok().body("Deleted");

    }
}

