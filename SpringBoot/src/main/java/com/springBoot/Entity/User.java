package com.springBoot.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;


@Entity (name = "users")
@Table (name = "users")
@Data
public class  User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String secondPassword;
    @Email (regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    private String role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Student student;


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
