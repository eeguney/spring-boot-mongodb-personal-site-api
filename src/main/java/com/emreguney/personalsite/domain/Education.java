package com.emreguney.personalsite.domain;

import com.emreguney.personalsite.model.WithDateAndOrder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document
public class Education extends WithDateAndOrder {

    @Id
    private Long id;

    // your major
    @NotBlank
    @Size(min = 2, max = 40)
    private String major;

    // school name
    @NotBlank
    @Size(min = 2, max = 60)
    private String schoolName;

    private String companyUrl;

    // short about article to explain your education
    @NotBlank
    @Size(min = 2, max = 140)
    private String about;

}
