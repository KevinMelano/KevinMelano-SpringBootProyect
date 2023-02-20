package com.springBoot.UserRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class UserRequest {
        @JsonProperty("code")
        private Long id;
        @NonNull
        @JsonProperty("userName")
        private String userName;
        @NonNull
        @JsonProperty("password")
        private String password;
        @NonNull
        @JsonProperty("secondPassword")
        private String secondPassword;
        @NonNull
        @JsonProperty("email")
        private String email;
        @NonNull
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
