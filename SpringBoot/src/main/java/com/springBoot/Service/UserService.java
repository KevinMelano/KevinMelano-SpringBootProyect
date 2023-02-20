package com.springBoot.Service;

import com.springBoot.Entity.User;
import com.springBoot.Exception.ResourceNotFoundException;
import com.springBoot.Factories.UserFactory;
import com.springBoot.Factories.UserResponseFactory;
import com.springBoot.Repository.UserRepository;
import com.springBoot.UserRequest.UserRequest;
import com.springBoot.UserResponse.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository usersRepository;

    @Autowired
    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Transactional
    public UserResponse save (UserRequest userRequest) {
        User user = UserFactory.from(userRequest);
        user = usersRepository.save(user);
      return UserResponseFactory.from(user);
    }

    @Transactional
    public List<UserResponse> findAll (){
        List<User> users = usersRepository.findAll();
        return users.stream().map(user -> UserResponseFactory.from(user)).collect(Collectors.toList());
    }

    @Transactional
    public UserResponse findById(Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        return UserResponseFactory.from(user);
    }
    @Transactional
    public UserResponse deleteById(Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
       return UserResponseFactory.from(user);
    }

    @Transactional
    public UserResponse update (UserRequest userRequest)  {
        User user = usersRepository.findById(userRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setSecondPassword(userRequest.getSecondPassword());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        return UserResponseFactory.from(user);
    }
}
