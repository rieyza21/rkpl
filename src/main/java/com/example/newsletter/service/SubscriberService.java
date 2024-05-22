package com.example.newsletter.service;


import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.SubscriberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public void subscribe(String email) {
        if (subscriberRepository.findByEmail(email) == null) {
            Subscriber subscriber = new Subscriber();
            subscriber.setEmail(email);
            subscriberRepository.save(subscriber);
        }

    }

    public List<Subscriber> getSubscriber() {
        return subscriberRepository.findAll();
    }

    public void deleteSubscriber(String id) {
        subscriberRepository.deleteById(id);
    }

    public void deleteAllSubscriber() {
        subscriberRepository.deleteAll();
    }
}
