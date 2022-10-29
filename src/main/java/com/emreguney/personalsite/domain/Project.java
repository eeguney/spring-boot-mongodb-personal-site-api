package com.emreguney.personalsite.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Project {

    @Id
    private Long id;

    // project name
    private String name;

    // project description
    private String description;

    // thumbnail for showing on cards
    private String thumbnail;

    // github url of project
    private String githubUrl;

    // preview url
    private String previewUrl;

    private List<String> tags;
}
