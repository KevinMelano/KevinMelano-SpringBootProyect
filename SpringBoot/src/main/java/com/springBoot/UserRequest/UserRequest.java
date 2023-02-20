package com.springBoot.UserRequest;

import lombok.Data;
@Data
public class UserRequest {

        private Long id;
        private String userName;
        private String password;
        private String secondPassword;
        private String email;
        private String role;

        public UserRequest(Long id, String userName, String password, String secondPassword, String email, String role) {
                this.id = id;
                this.userName = userName;
                this.password = password;
                this.secondPassword = secondPassword;
                this.email = email;
                this.role = role;
        }
}
