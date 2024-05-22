package com.example.newsletter.service;

import com.example.newsletter.model.Newsletter;
import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.NewsletterRepository;
import com.example.newsletter.repository.SubscriberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class NewsletterService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Autowired
    private View error;

    public Newsletter setNewsletter(Newsletter newsletter) {
        Optional<Newsletter> optionalNewsletter = newsletterRepository.findById(newsletter.getId());
        if (optionalNewsletter.isPresent()) {
            throw new RuntimeException("Newsletter with id " + newsletter.getId() + " already exists");
        } else return newsletterRepository.save(newsletter);
    }

    public void sendNewsletter(Newsletter newsletter) {
        Optional<Newsletter> optionalNewsletter = newsletterRepository.findById(newsletter.getId());
        if (optionalNewsletter.isPresent()) {
            Newsletter newsletter1 = optionalNewsletter.get();
            SimpleMailMessage message = new SimpleMailMessage();
            for (Subscriber subscriber : subscriberRepository.findAll()) {
                message.setTo(subscriber.getEmail());
                message.setSubject(newsletter1.getSubject());
                message.setText(newsletter1.getContent());
                mailSender.send(message);
            }
        } else {
            throw new RuntimeException("Newsletter with id " + newsletter.getId() + " not found");
        }
    }

    public List<Newsletter> getNewsletter() {
        return newsletterRepository.findAll();
    }

    public void deleteNewsletter(String id) {
        newsletterRepository.deleteById(id);
    }

    public void deleteAllNewsletters() {
        newsletterRepository.deleteAll();
    }
}