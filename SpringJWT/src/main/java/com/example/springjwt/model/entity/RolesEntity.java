package com.example.springjwt.model.entity;

import com.example.springjwt.model.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public RolesEntity() {

    }

    public RolesEntity(Roles role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public RolesEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Roles getRole() {
        return role;
    }

    public RolesEntity setRole(Roles role) {
        this.role = role;
        return this;
    }

}

