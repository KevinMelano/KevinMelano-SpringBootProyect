package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {
    @JsonProperty("code")
    private Long id;

    @JsonProperty("role")
    private String role;

    @JsonCreator
    public RoleRequest(@JsonProperty("code")Long id,
                       @JsonProperty("role")String role) {
        this.id = id;
        this.role = role;
    }
}
