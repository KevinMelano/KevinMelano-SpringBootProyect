package com.springBoot.Factories;

import com.springBoot.Entity.Student;
import com.springBoot.UserResponse.StudentResponse;

public class StudentsResponseFactory {

    public static StudentResponse from (Student student) {
       return new StudentResponse(
               student.getId(),
               student.getAvatar(),
               student.getName(),
               student.getLastName(),
               student.getCountry(),
               student.getCity(),
               student.getEmail());
    }
}
