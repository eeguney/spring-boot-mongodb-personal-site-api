package com.emreguney.personalsite.service.impl;

import com.emreguney.personalsite.domain.Experience;
import com.emreguney.personalsite.repository.ExperienceRepository;
import com.emreguney.personalsite.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ExperienceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;


    @Override
    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }


    @Override
    public List<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience updateOrCreate(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> multipleUpdateOrCreate(List<Experience> experiences) {
        return experienceRepository.saveAll(experiences);
    }

    @Override
    public void deleteAnExperienceWithId(Long id) {
        experienceRepository.deleteById(id);
    }
}
