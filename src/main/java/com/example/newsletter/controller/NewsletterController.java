package com.example.newsletter.controller;

import com.example.newsletter.model.ContactMessage;
import com.example.newsletter.model.Newsletter;
import com.example.newsletter.model.Subscriber;
import com.example.newsletter.service.NewsletterService;
import com.example.newsletter.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;
    

    @PostMapping("/set")
    public void setNewsletter(@RequestBody Newsletter newsletter) {
        newsletterService.setNewsletter(newsletter);
    }

    @PostMapping("/send")
    public void sendNewsletter(@RequestBody Newsletter newsletter) {
        newsletterService.sendNewsletter(newsletter);

    }

    @GetMapping("/newsletter")
    public List<Newsletter> getNewsletter() {
        return newsletterService.getNewsletter();
    }

    @DeleteMapping("/newsletter/{id}")
    public void deleteNewsletter(@PathVariable String id) {
        newsletterService.deleteNewsletter(id);
    }

    @DeleteMapping("/newsletter")
    public void deleteAllNewsletter() {
        newsletterService.deleteAllNewsletters();
    }

}