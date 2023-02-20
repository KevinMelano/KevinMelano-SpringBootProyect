package com.springBoot.Factories;

import com.springBoot.Entity.User;
import com.springBoot.UserResponse.UserResponse;

public class UserResponseFactory {

    public static UserResponse from (User user) {
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getSecondPassword(),
                user.getEmail(),
                user.getRole());
    }
}
