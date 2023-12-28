package com.quinbay.customer.jwtUtil;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.String.valueOf;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "Quinbay";

    public String generateToken(long userId) {
        return Jwts.builder()
                .setSubject(valueOf(userId))
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}
