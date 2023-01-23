package com.javaguides.springbootrestfullwebservices.service;

import com.javaguides.springbootrestfullwebservices.entity.User;
import com.javaguides.springbootrestfullwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

}
