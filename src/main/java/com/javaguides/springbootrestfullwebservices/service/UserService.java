package com.javaguides.springbootrestfullwebservices.service;

import com.javaguides.springbootrestfullwebservices.entity.User;
import com.javaguides.springbootrestfullwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user =  this.userRepository.findById(id);
        return user.get();
    }

    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    public User updateUserInfos (User user) {
        User user1 =  this.userRepository.findById(user.getId()).get();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());

        return this.userRepository.save(user1);
    }

    public String deleteUserById(Long id) {
        this.userRepository.deleteById(id);
        return "User Successfully Deleted !";
    }
}
