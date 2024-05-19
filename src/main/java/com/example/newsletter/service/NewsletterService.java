package com.example.newsletter.service;

import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void subscribe(String email) {
        if (subscriberRepository.findByEmail(email) == null) {
            Subscriber subscriber = new Subscriber();
            subscriber.setEmail(email);
            subscriberRepository.save(subscriber);
        }


    }

    public void sendNewsletter(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        for (Subscriber subscriber : subscriberRepository.findAll()) {
            message.setTo(subscriber.getEmail());
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
        }
    }

}