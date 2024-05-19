package com.example.newsletter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "contactMessages")
public class ContactMessage {
    @Id
    private String id;
    private String name;
    private String email;
    private String message;
}
