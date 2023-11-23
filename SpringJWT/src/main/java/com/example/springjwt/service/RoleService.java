package com.example.springjwt.service;

import com.example.springjwt.model.entity.RolesEntity;
import com.example.springjwt.model.enums.Roles;
import com.example.springjwt.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void addRole(Roles role) {
        this.roleRepository.save(new RolesEntity(role));
    }
}
