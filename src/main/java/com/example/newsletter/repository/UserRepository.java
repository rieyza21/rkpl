package com.example.newsletter.repository;

import com.example.newsletter.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}