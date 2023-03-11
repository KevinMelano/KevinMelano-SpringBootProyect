package com.springBoot.Service;

import com.springBoot.Entity.User;
import com.springBoot.Exception.FormatEmailException;
import com.springBoot.Exception.MismatchedInputException;
import com.springBoot.Exception.ResourceNotFoundException;
import com.springBoot.Factories.UserFactory;
import com.springBoot.Factories.UserResponseFactory;
import com.springBoot.Repository.UserRepository;
import com.springBoot.UserRequest.*;
import com.springBoot.UserResponse.UserResponse;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository usersRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
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
    public UserResponse save (UserRequest userRequest) {
        User user = UserFactory.from(userRequest);
        user = usersRepository.save(user);
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
    @Transactional
    public UserResponse updateUserName(UserNameRequest userNameRequest) {
        User user = usersRepository.findById(userNameRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        user.setUserName(userNameRequest.getUserName());
        return UserResponseFactory.from(usersRepository.save(user));
    }
    @Transactional
    public UserResponse updatePassword (PasswordRequest passwordRequest) {
        User user = usersRepository.findById(passwordRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        if (!passwordRequest.getPassword().equals(passwordRequest.getSecondPassword())) {
            throw new MismatchedInputException("Passwords do not match");
        }
        user.setPassword(passwordRequest.getPassword());
        user.setSecondPassword(passwordRequest.getSecondPassword());
        return UserResponseFactory.from(usersRepository.save(user));
    }
    @Transactional
    public UserResponse updateRole (RoleRequest roleRequest) {
        User user = usersRepository.findById(roleRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        user.setRole(roleRequest.getRole());
        return UserResponseFactory.from(usersRepository.save(user));
    }
    @Transactional
    public UserResponse updateEmail (EmailRequest emailRequest) {
        User user = usersRepository.findById(emailRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        if (!validateEmail(emailRequest.getEmail())) {
            throw new FormatEmailException("Invalid email format");
        }
        user.setEmail(emailRequest.getEmail());
        return UserResponseFactory.from(usersRepository.save(user));
    }
    @Transactional
    public UserResponse deleteById(Long id) {
        User user = usersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        usersRepository.deleteById(id);
       return UserResponseFactory.from(user);
    }
    private boolean validateEmail (String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public UserResponse findUserName (UserLoginRequest userLoginRequest) {
        try (Session session = sessionFactory.openSession()){
            Query query = session.createQuery("from users where userName ilike :userName", User.class);
            query.setParameter("userName",userLoginRequest.getUserName());
            User user = (User) query.getSingleResult();
            return UserResponseFactory.from(user);
        }catch (NoResultException e){
            throw new ResourceNotFoundException("Invalid user name");
        }
    }

}
