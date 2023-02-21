package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRequest {
        @JsonProperty("code")
        private Long id;

        @JsonProperty("userName")
        private String userName;

        @JsonProperty("password")
        private String password;

        @JsonProperty("secondPassword")
        private String secondPassword;

        @JsonProperty("email")
        private String email;

        @JsonProperty("role")
        private String role;

        @JsonCreator
        public UserRequest(@JsonProperty("code") Long id,
                           @JsonProperty("userName")String userName,
                           @JsonProperty("password")String password,
                           @JsonProperty("secondPassword") String secondPassword,
                           @JsonProperty("email")String email,
                           @JsonProperty("role")String role) {
                this.id = id;
                this.userName = userName;
                this.password = password;
                this.secondPassword = secondPassword;
                this.email = email;
                this.role = role;
        }
}
