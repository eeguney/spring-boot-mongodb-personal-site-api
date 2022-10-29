package com.emreguney.personalsite.domain;

import com.emreguney.personalsite.model.WithDateAndOrder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Experience extends WithDateAndOrder {

    @Id
    private Long id;

    // title for job or experience
    private String title;

    private String companyName;

    private String companyUrl;

    // short about article to explain your role in this job
    private String about;

    // technologies you use in this job
    private List<String> technologies;

    // your job's location
    private String location;
}
