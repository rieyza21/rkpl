package com.example.newsletter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menuItems")
public class MenuItem {
    @Id
    private String id;
    private String name;
    private double price;
    private String imageUrl;
    private String description;
}
