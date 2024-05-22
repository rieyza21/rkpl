package com.example.newsletter.controller;

import com.example.newsletter.model.ContactMessage;
import com.example.newsletter.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactMessage createContactMessage(@RequestBody ContactMessage contactMessage) {
        return contactService.saveContactMessage(contactMessage);
    }

    @GetMapping
    public List<ContactMessage> getAllContactMessages() {
        return contactService.getContactMessages();
    }

    @DeleteMapping
    public void deleteAllContactMessages() {
        contactService.deleteAllMessages();
    }

    @DeleteMapping("/{id}")
    public void deleteContactMessage(@PathVariable String id) {
        contactService.deleteMessages(id);
    }
}