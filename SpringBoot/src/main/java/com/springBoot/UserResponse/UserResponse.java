package com.springBoot.UserResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class UserResponse {

    @JsonProperty(value = "code")
    private Long id;
    private String userName;
    private String password;
    private String secondPassword;
    private String email;
    private String role;


    public UserResponse(Long id, String userName, String password, String secondPassword, String email, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.secondPassword = secondPassword;
        this.email = email;
        this.role = role;
    }
}
