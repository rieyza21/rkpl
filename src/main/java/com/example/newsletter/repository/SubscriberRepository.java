package com.example.newsletter.repository;

import com.example.newsletter.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
    Subscriber findByEmail(String email);
}
