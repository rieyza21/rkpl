package com.example.newsletter.controller;

import com.example.newsletter.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @PostMapping("/subscribe")
    public void subscribe(@RequestBody String email) {
        newsletterService.subscribe(email);
    }

    @PostMapping("/send")
    public void sendNewsletter(@RequestBody Map<String, String> payload) {
        String subject = payload.get("subject");
        String content = payload.get("content");
        newsletterService.sendNewsletter(subject, content);
    }
}