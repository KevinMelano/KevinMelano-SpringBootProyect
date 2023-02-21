package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    @JsonProperty("code")
    private Long id;
    @JsonProperty("email")
    private String email;
    @JsonCreator
    public EmailRequest(@JsonProperty("code")Long id,
                        @JsonProperty("email")String email) {
        this.id = id;
        this.email = email;
    }
}
