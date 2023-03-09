package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLoginRequest {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonCreator
    public UserLoginRequest(@JsonProperty("userName")String userName,
                            @JsonProperty("password")String password){
        this.userName = userName;
        this.password = password;
    }

}
