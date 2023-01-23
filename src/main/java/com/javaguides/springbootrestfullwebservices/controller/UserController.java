package com.javaguides.springbootrestfullwebservices.controller;

import com.javaguides.springbootrestfullwebservices.entity.User;
import com.javaguides.springbootrestfullwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user API REST
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println("Create User: " + user.getEmail());

        User user1 = this.userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
}
