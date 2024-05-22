package com.example.newsletter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "newsletters")

@AllArgsConstructor
@NoArgsConstructor
public class Newsletter {
    @Id
    private String id;
    private String subject;
    private String content;
}
