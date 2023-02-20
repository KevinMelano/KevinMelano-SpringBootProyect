package com.springBoot.Service;

import com.springBoot.Entity.User;
import com.springBoot.Exception.ResourceNotFoundException;
import com.springBoot.Factories.UserFactory;
import com.springBoot.Factories.UserResponseFactory;
import com.springBoot.Repository.UserRepository;
import com.springBoot.UserRequest.UserRequest;
import com.springBoot.UserResponse.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        usersRepository.deleteById(id);
       return UserResponseFactory.from(user);
    }

    @Transactional
    public UserResponse update (UserRequest userRequest)  {
        if (userRequest.getId() == null && !usersRepository.existsById(userRequest.getId())){
            throw new ResourceNotFoundException("Id not found");
        }
        User user = UserFactory.from(userRequest);
        user = usersRepository.save(user);
        return UserResponseFactory.from(user);
    }

    // Crear el Patch para cada Atributo del Entity
    @Transactional
    public UserResponse patchUpdate (UserRequest userRequest) {
        User user = usersRepository.findById(userRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        User newUser = UserFactory.from(userRequest);

        if(newUser.getUserName() != null && !newUser.getUserName().equals(user.getUserName())) user.setUserName(newUser.getUserName());
        if(newUser.getPassword() != null && !newUser.getPassword().equals(user.getPassword())) user.setPassword(newUser.getPassword());
        if(newUser.getSecondPassword() != null && !newUser.getSecondPassword().equals(user.getSecondPassword())) user.setSecondPassword(newUser.getSecondPassword());
        if(newUser.getEmail() != null && !newUser.getEmail().equals(user.getEmail())) user.setEmail(newUser.getEmail());
        if(newUser.getRole() != null && !newUser.getRole().equals(user.getRole())) user.setRole(newUser.getRole());
        return UserResponseFactory.from(usersRepository.save(user));
    }
}
