package com.emreguney.personalsite.controllers;

import com.emreguney.personalsite.domain.Education;
import com.emreguney.personalsite.exception.DataIsNotValidException;
import com.emreguney.personalsite.exception.NotFoundException;
import com.emreguney.personalsite.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/education")
public class EducationController {

    EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = educationService.getEducations();
        return ResponseEntity.ok().body(educations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Education>> getAnEducation(@PathVariable Long id) throws NotFoundException {
        Optional<Education> education = educationService.getEducationById(id);
        if (education.isEmpty()) {
            throw new NotFoundException("There is no education item with this Id");
        }
        return ResponseEntity.ok().body(education);

    }

    @PostMapping("/")
    public ResponseEntity<Education> save(@Valid @RequestBody Education education) throws DataIsNotValidException {
        try {
            Education newEducation = educationService.updateOrCreate(education);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/education").toUriString());
            return ResponseEntity.created(uri).body(newEducation);
        } catch (ConstraintViolationException e) {
            throw new DataIsNotValidException("Data is not valid:" + e.getMessage());
        }
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Education>> saveMultipleEducation(@Valid @RequestBody List<Education> educations) throws DataIsNotValidException {
        try {
            List<Education> newEducations = educationService.multipleUpdateOrCreate(educations);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/education/multiple").toUriString());
            return ResponseEntity.created(uri).body(newEducations);
        } catch (ConstraintViolationException e) {
            throw new DataIsNotValidException("Data is not valid: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnEducationWithId(@PathVariable Long id) throws NotFoundException {
        Optional<Education> thatEducation = educationService.getEducationById(id);
        if (thatEducation.isEmpty()) {
            throw new NotFoundException("There is no education with this Id: ");
        }
        educationService.deleteAnEducationWithId(id);
        return ResponseEntity.ok().body("Deleted");

    }
}

