package com.springBoot.UserResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class UserResponse {

    @JsonProperty(value = "code")
    private Long id;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "secondPassword")
    private String secondPassword;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "role")
    private String role;

    @JsonCreator
    public UserResponse(@JsonProperty(value = "code")Long id,
                        @JsonProperty(value = "userName")String userName,
                        @JsonProperty(value = "password")String password,
                        @JsonProperty(value = "secondPassword")String secondPassword,
                        @JsonProperty(value = "email")String email,
                        @JsonProperty(value = "role")String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.secondPassword = secondPassword;
        this.email = email;
        this.role = role;
    }
}
