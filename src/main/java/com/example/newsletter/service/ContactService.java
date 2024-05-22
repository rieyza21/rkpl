package com.example.newsletter.service;

import com.example.newsletter.model.ContactMessage;
import com.example.newsletter.repository.ContactMessageRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class ContactService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage saveContactMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }

    public List<ContactMessage> getContactMessages() {
        return contactMessageRepository.findAll();
    }

    public void deleteMessages(String id) {
        contactMessageRepository.deleteById(id);
    }

    public void deleteAllMessages() {
        contactMessageRepository.deleteAll();
    }
}