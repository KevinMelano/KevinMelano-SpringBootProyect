package com.springBoot.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table (name = "users")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String secondPassword;
    private String email;
    private String role;

    public User() {
    }

    public User(Long id, String userName, String password, String secondPassword, String email, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.secondPassword = secondPassword;
        this.email = email;
        this.role = role;
    }
}
