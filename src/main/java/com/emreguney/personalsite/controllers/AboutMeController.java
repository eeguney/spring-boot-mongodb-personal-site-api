package com.emreguney.personalsite.controllers;

import com.emreguney.personalsite.domain.AboutMe;
import com.emreguney.personalsite.service.impl.AboutMeImpl;
import com.emreguney.personalsite.service.AboutMeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/aboutme")
public class AboutMeController {

    AboutMeService aboutMeService;

     Logger logger = LoggerFactory.getLogger(AboutMeImpl.class);

    public AboutMeController(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping
    public ResponseEntity<AboutMe> getAboutMe() {
        AboutMe aboutMe = aboutMeService.getAboutme();
        return ResponseEntity.ok().body(aboutMe);
    }

    @PostMapping("/")
    public ResponseEntity<AboutMe> save(@Valid @RequestBody  AboutMe aboutMe) {
        AboutMe newAboutMe = aboutMeService.updateOrCreate(aboutMe);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/aboutme").toUriString());
        return ResponseEntity.created(uri).body(newAboutMe);
    }

}
