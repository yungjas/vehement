package com.vehement.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection="journal")
@Getter
@Setter
@AllArgsConstructor
public class Journal {
    @Id
    private String journalId;

    private String title;

    private String desc;

    private String authorUsername;

    private String datePublished;

    private String dateEdited;

    private Boolean isPublic;
}
