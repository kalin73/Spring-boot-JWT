package com.example.springjwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    public String issue(long userId, String username, List<String> roles) {
        Instant now = Instant.now();

        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withIssuedAt(now)
                .withExpiresAt(now.plus(Duration.of(5, ChronoUnit.MINUTES)))
                .withClaim("u", username)
                .withClaim("au", roles)
                .sign(Algorithm.HMAC256(secretKey));
    }
}
