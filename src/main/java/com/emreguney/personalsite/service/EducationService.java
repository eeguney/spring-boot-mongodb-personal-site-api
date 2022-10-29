package com.emreguney.personalsite.service;


import com.emreguney.personalsite.domain.Education;
import com.emreguney.personalsite.exception.DataIsNotValidException;
import com.emreguney.personalsite.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface EducationService {

    Optional<Education> getEducationById(Long id) throws NotFoundException;

    List<Education> getEducations();

    Education updateOrCreate(Education education) throws DataIsNotValidException;

    List<Education> multipleUpdateOrCreate(List<Education> educations) throws DataIsNotValidException;

    void deleteAnEducationWithId(Long id) throws NotFoundException;

}
