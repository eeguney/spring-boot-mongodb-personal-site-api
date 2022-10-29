package com.emreguney.personalsite.service.impl;

import com.emreguney.personalsite.domain.Education;
import com.emreguney.personalsite.repository.EducationRepository;
import com.emreguney.personalsite.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EducationImpl implements EducationService {

    private final EducationRepository educationRepository;


    @Override
    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Education updateOrCreate(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public List<Education> multipleUpdateOrCreate(List<Education> educations) {
        return educationRepository.saveAll(educations);
    }

    @Override
    public void deleteAnEducationWithId(Long id) {
        educationRepository.deleteById(id);
    }
}
