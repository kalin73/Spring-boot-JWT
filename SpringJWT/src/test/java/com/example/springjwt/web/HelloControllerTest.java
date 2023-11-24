package com.example.springjwt.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class HelloControllerTest {
    @Autowired
    private MockMvc api;

    @Test
    void anyoneCanViewPublicEndpoint() throws Exception {
        api.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsStringIgnoringCase("Hello")));
    }

    @Test
    void notLoggedInShouldNotSeeSecuredEndpoint() throws Exception {
        api.perform(get("/secured"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void loggedInShouldSeeSecuredEndpoint() throws Exception {
        api.perform((get("/secured")))
                .andExpect((status().isOk()))
                .andExpect(content().string(containsStringIgnoringCase("User ID: 1")));
    }

    @Test
    void notLoggedInShouldNotSeeAdminEndpoint() throws Exception {
        api.perform(get("/admin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void simpleUserShouldNotSeeAdminEndpoint() throws Exception {
        api.perform((get("/admin")))
                .andExpect((status().isForbidden()));
    }

    @Test
    @WithAdminUser
    void adminShouldSeeAdminEndpoint() throws Exception {
        api.perform((get("/admin")))
                .andExpect((status().isOk()));
    }
}
