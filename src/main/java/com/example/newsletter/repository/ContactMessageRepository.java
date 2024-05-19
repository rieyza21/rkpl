package com.example.newsletter.repository;

import com.example.newsletter.model.ContactMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactMessageRepository extends MongoRepository<ContactMessage, String> {
}
