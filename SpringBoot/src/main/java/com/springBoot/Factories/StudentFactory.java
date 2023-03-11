package com.springBoot.Factories;

import com.springBoot.Entity.Student;
import com.springBoot.UserRequest.StudentRequest;

public class StudentFactory {

    public static Student from (StudentRequest studentRequest) {
        return new Student(
                studentRequest.getId(),
                studentRequest.getAvatar(),
                studentRequest.getName(),
                studentRequest.getLastName(),
                studentRequest.getCountry(),
                studentRequest.getCity(),
                studentRequest.getEmail());
    }
}
