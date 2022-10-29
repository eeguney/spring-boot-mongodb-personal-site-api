package com.emreguney.personalsite.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document
public class AboutMe {

    // site owner name - e.g: Emre Güney
    @NotBlank
    @Size(min = 2, max = 40)
    private String fullname;

    // a short about me article for showing on landing page
    @NotBlank
    @Size(min = 10, max = 120)
    private String shortAboutMe;

    // a about me article for showing on about me page
    @NotBlank
    @Size(min = 10, max = 240)
    private String aboutMe;

    private String userPhoto;

}
