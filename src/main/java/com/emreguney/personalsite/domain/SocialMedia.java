package com.emreguney.personalsite.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SocialMedia {

    @Id
    private Long id;

    // social media name
    private String name;

    // social media url
    private String url;

    // order of social media items
    private Integer order;

}
