package com.noobsmoke.springsecure.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretKey = "BigBangAttackfsaljkdflaudialvnsidsaodfaosdufaoij"; //Not safe! Just for learning right now

    public String generateToken(String username) {
        Map<String, String> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .issuer("BasedUster")
                .and()
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }
}
