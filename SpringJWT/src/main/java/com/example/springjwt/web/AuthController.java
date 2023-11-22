package com.example.springjwt.web;

import com.example.springjwt.model.LoginRequest;
import com.example.springjwt.model.LoginResponse;
import com.example.springjwt.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String token = jwtIssuer.issue(1L, loginRequest.getEmail(), List.of("USER"));

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
