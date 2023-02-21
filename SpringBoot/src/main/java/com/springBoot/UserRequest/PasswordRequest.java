package com.springBoot.UserRequest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordRequest {
    @JsonProperty("code")
    private Long id;

    @JsonProperty("password")
    private String password;
    @JsonProperty("secondPassword")
    private String secondPassword;

    @JsonCreator
    public PasswordRequest(@JsonProperty("code")Long id,
                           @JsonProperty("password")String password,
                           @JsonProperty("secondPassword")String secondPassword) {
        this.id = id;
        this.password = password;
        this.secondPassword = secondPassword;
    }
}
