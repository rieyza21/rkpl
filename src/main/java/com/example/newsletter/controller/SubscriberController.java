package com.example.newsletter.controller;


import com.example.newsletter.model.Subscriber;
import com.example.newsletter.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriber")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/subscribe")
    public void subscribe(@RequestBody String email) {
        subscriberService.subscribe(email);
    }

    @GetMapping("/subscriber")
    public List<Subscriber> getSubscriber() {
        return subscriberService.getSubscriber();
    }

    @DeleteMapping("/subscriber/{id}")
    public void deleteSubscriber(@PathVariable String id) {
        subscriberService.deleteSubscriber(id);
    }

    @DeleteMapping("/subscriber")
    public void deleteAllSubscriber() {
        subscriberService.deleteAllSubscriber();
    }
}
