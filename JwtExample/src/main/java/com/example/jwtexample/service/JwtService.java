package com.example.jwtexample.service;

import com.example.jwtexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final UserRepository userRepository;

    public String extractUsername(String jwt) {
        return null;
    }
}
