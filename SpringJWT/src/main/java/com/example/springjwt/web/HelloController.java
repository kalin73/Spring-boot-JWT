package com.example.springjwt.web;

import com.example.springjwt.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "Hello, world!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "User ID: " + principal.getUserId() + "\nUsername: " + principal.getUsername() + "\nRole: " + getAuthority(principal);
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "Hello admin: " + principal.getUsername() + "\nRole: " + getAuthority(principal);
    }

    private String getAuthority(UserPrincipal principal) {
        return principal.getAuthorities()
                .stream()
                .filter(x -> x.getAuthority().contains("USER") || x.getAuthority().contains("ADMIN"))
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
    }
}
