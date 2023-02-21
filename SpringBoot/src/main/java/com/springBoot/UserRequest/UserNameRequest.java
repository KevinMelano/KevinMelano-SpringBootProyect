package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNameRequest {
    @JsonProperty("code")
    private Long id;

    @JsonProperty("userName")
    private String userName;

    @JsonCreator
    public UserNameRequest(@JsonProperty("code")Long id,
                           @JsonProperty("userName")String userName) {
        this.id = id;
        this.userName = userName;
    }
}
