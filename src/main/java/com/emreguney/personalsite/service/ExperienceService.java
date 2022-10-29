package com.emreguney.personalsite.service;


import com.emreguney.personalsite.domain.Experience;
import com.emreguney.personalsite.exception.DataIsNotValidException;
import com.emreguney.personalsite.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {

    Optional<Experience> getExperienceById(Long id) throws NotFoundException;

    List<Experience> getExperiences();

    Experience updateOrCreate(Experience experience) throws DataIsNotValidException;

    List<Experience> multipleUpdateOrCreate(List<Experience> experiences) throws DataIsNotValidException;

    void deleteAnExperienceWithId(Long id) throws NotFoundException;

}
