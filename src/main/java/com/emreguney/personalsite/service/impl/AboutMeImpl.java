package com.emreguney.personalsite.service.impl;

import com.emreguney.personalsite.domain.AboutMe;
import com.emreguney.personalsite.exception.NotFoundException;
import com.emreguney.personalsite.repository.AboutMeRepository;
import com.emreguney.personalsite.service.AboutMeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AboutMeImpl implements AboutMeService {

    private final AboutMeRepository aboutMeRepository;

    private final Logger logger = LoggerFactory.getLogger(AboutMeImpl.class);

    @Override
    public AboutMe getAboutme() throws NotFoundException {
        List<AboutMe> aboutMe = aboutMeRepository.findAll();
        if (aboutMe.size() < 1) {
            throw new NotFoundException("We can not find any user, I think you should create a user on api/aboutme");
        }
        return aboutMe.get(0);
    }

    @Override
    public AboutMe updateOrCreate(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }
}
