package com.varsemployeeportal.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;



@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
public class User {

    // getters & setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    private String role;

    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
