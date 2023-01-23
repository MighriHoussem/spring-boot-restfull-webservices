package com.javaguides.springbootrestfullwebservices.controller;

import com.javaguides.springbootrestfullwebservices.entity.User;
import com.javaguides.springbootrestfullwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    //REST API get user by id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
        User user =  this.userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //REST API get all users
    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers () {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }


    //REST API update user by id
    @PutMapping("{id}/update")
    public ResponseEntity<User> updateUserInfos(@PathVariable Long id,
            @RequestBody User user) {
        User updatedUser = this.userService.updateUserInfos(user);
        return ResponseEntity.ok(updatedUser);
    }

    //Rest API Delete user By Id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserByID (@PathVariable("id") Long userID){
        return new ResponseEntity<>(this.userService.deleteUserById(userID) , HttpStatus.OK);
    }
}
