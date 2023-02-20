package com.springBoot.Factories;

import com.springBoot.Entity.User;
import com.springBoot.UserRequest.UserRequest;

public class UserFactory {
    public static User from (UserRequest userRequest) {
        return new User(
                userRequest.getId(),
                userRequest.getUserName(),
                userRequest.getPassword(),
                userRequest.getSecondPassword(),
                userRequest.getEmail(),
                userRequest.getRole());
    }
}
