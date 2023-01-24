package com.javaguides.springbootrestfullwebservices.service;

import com.javaguides.springbootrestfullwebservices.dto.UserDTO;
import com.javaguides.springbootrestfullwebservices.entity.User;
import com.javaguides.springbootrestfullwebservices.mapper.UserMapper;
import com.javaguides.springbootrestfullwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        //convert userDTO object to JPA User Entity
        User user = UserMapper.convertToUserEntity(userDTO);
        User savedUser = this.userRepository.save(user);
        //convert User JPA Entity to UserDTO Object
        UserDTO savedUserDTO = UserMapper.convertToUserDTO(savedUser);
        return savedUserDTO;
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user =  this.userRepository.findById(id);
        UserDTO userDTO = UserMapper.convertToUserDTO(user.get());
        return userDTO;
    }

    public List<UserDTO> getAllUsers () {
        List<User> userList = this.userRepository.findAll();
        return userList.stream()
                .map(UserMapper::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUserInfos (UserDTO user) {
        User user1 =  this.userRepository.findById(user.getId()).get();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());

        User savedUser = this.userRepository.save(user1);
        return UserMapper.convertToUserDTO(savedUser);
    }

    public String deleteUserById(Long id) {
        this.userRepository.deleteById(id);
        return "User Successfully Deleted !";
    }
}
