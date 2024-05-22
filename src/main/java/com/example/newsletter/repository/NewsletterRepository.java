package com.example.newsletter.repository;

import com.example.newsletter.model.Newsletter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NewsletterRepository extends MongoRepository<Newsletter, String>{
    Optional<Newsletter> findById(String id);
}
