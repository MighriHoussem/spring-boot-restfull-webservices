package com.javaguides.springbootrestfullwebservices.controller;

import com.javaguides.springbootrestfullwebservices.dto.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        System.out.println("Create User: " + user.getEmail());

        UserDTO savedUserDTO = this.userService.createUser(user);
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }


    //REST API get user by id
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable Long id) {
        UserDTO user =  this.userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //REST API get all users
    @GetMapping("all")
    public ResponseEntity<List<UserDTO>> getAllUsers () {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }


    //REST API update user by id
    @PutMapping("{id}/update")
    public ResponseEntity<UserDTO> updateUserInfos(@PathVariable Long id,
            @RequestBody UserDTO user) {
        UserDTO updatedUser = this.userService.updateUserInfos(user);
        return ResponseEntity.ok(updatedUser);
    }

    //Rest API Delete user By Id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserByID (@PathVariable("id") Long userID){
        return new ResponseEntity<>(this.userService.deleteUserById(userID) , HttpStatus.OK);
    }
}
