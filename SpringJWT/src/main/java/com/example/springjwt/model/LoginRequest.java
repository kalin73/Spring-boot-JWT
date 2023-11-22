package com.example.springjwt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
