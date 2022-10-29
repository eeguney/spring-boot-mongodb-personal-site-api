package com.emreguney.personalsite.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Skill {

    @Id
    private Long id;

    // skill name
    private String name;

    // icon url
    private String iconUrl;

    // order of the skill
    private Integer order;

}
