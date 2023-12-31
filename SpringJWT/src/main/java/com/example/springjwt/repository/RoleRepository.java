package com.example.springjwt.repository;

import com.example.springjwt.model.entity.RolesEntity;
import com.example.springjwt.model.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
    RolesEntity findAllByRole(Roles roles);
}
