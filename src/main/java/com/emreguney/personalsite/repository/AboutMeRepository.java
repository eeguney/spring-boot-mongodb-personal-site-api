package com.emreguney.personalsite.repository;

import com.emreguney.personalsite.domain.AboutMe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AboutMeRepository extends MongoRepository<AboutMe, String> {

    @Query("{fullname:'?0'}")
    AboutMe findItemByName(String fullname);

}
