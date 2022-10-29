package com.emreguney.personalsite.repository;

import com.emreguney.personalsite.domain.Education;
import com.emreguney.personalsite.domain.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ExperienceRepository extends MongoRepository<Experience, Long> {


}
