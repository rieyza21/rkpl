package com.example.newsletter.service;

import com.example.newsletter.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService implements Filter {
    private final String SECRET_KEY = "7afcd8020bbcbaf86d6825c38e5b7bd744f349d705a811e99290b90cb2907200";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(User user) {
        String token = Jwts
                .builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }

    private SecretKey getSignInKey() {
      byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
      return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}

