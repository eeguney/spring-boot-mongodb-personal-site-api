package com.emreguney.personalsite.repository;

import com.emreguney.personalsite.domain.AboutMe;
import com.emreguney.personalsite.domain.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EducationRepository extends MongoRepository<Education, Long> {


}
