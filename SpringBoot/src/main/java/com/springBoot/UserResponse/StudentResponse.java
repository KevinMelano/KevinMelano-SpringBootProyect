package com.springBoot.UserResponse;

import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String avatar;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String email;

    public StudentResponse(Long id, String avatar, String name, String lastName, String country, String city, String email) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.email = email;
    }
}
