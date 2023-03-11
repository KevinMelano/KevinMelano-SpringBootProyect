package com.springBoot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String avatar;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
    public Student() {
    }

    public Student(Long id, String avatar, String name, String lastName, String country, String city, String email) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.email = email;
    }
}
