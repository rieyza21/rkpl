package com.example.newsletter.model;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
