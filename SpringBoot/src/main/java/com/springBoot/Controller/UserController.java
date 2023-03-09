package com.springBoot.Controller;

import com.springBoot.Entity.User;
import com.springBoot.Exception.ResourceNotFoundException;
import com.springBoot.Service.UserService;
import com.springBoot.UserRequest.*;
import com.springBoot.UserResponse.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/users")
public class UserController {

    private UserService usersService;
    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll (){
      List<UserResponse> userResponse = usersService.findAll();
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById (@PathVariable Long id){
        UserResponse userResponse = usersService.findById(id);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> saveUser (@RequestBody UserRequest userRequest){
        UserResponse userResponse = usersService.save(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponse> update (@RequestBody UserRequest userRequest){
        UserResponse userResponse = usersService.update(userRequest);
        return ResponseEntity.ok(userResponse);
    }
    @PatchMapping("/updateUserName")
    public ResponseEntity<UserResponse> updateUserName (@RequestBody UserNameRequest userNameRequest) {
        UserResponse userResponse = usersService.updateUserName(userNameRequest);
        return ResponseEntity.ok(userResponse);
    }
    @PatchMapping("/updatePassword")
    public ResponseEntity<UserResponse> updatePassword (@RequestBody PasswordRequest passwordRequest) {
        UserResponse userResponse = usersService.updatePassword(passwordRequest);
        return ResponseEntity.ok(userResponse);
    }
    @PatchMapping("/updateRole")
    public ResponseEntity<UserResponse> updateRole (@RequestBody RoleRequest roleRequest) {
        UserResponse userResponse = usersService.updateRole(roleRequest);
        return ResponseEntity.ok(userResponse);
    }
    @PatchMapping("/updateEmail")
    public ResponseEntity<UserResponse> updateEmail (@RequestBody EmailRequest emailRequest) {
        UserResponse userResponse = usersService.updateEmail(emailRequest);
        return ResponseEntity.ok(userResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteById (@PathVariable Long id) {
       UserResponse userResponse = usersService.deleteById(id);
        return ResponseEntity.ok(userResponse);
    }
    @GetMapping("/login")
    public ResponseEntity<UserResponse> login (@RequestBody UserLoginRequest userLoginRequest){
        UserResponse userResponse = usersService.findUserName(userLoginRequest);
        if (!userResponse.getPassword().equals(userLoginRequest.getPassword())) {
            throw new ResourceNotFoundException("Invalid password");
        }
        return ResponseEntity.ok().build();
    }
}
