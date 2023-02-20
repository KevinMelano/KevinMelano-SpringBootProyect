package com.springBoot.Controller;

import com.springBoot.Service.UserService;
import com.springBoot.UserRequest.UserRequest;
import com.springBoot.UserResponse.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PatchMapping("/patchupdate")
    public ResponseEntity<UserResponse> patchUpdate (@RequestBody UserRequest userRequest) {
        UserResponse userResponse = usersService.patchUpdate(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteById (@PathVariable Long id) {
       UserResponse userResponse = usersService.deleteById(id);
        return ResponseEntity.ok(userResponse);
    }

}
