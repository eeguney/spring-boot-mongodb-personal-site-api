package com.emreguney.personalsite.service;

import com.emreguney.personalsite.domain.AboutMe;

public interface AboutMeService {

    AboutMe getAboutme();

    AboutMe updateOrCreate(AboutMe aboutMe);

}
