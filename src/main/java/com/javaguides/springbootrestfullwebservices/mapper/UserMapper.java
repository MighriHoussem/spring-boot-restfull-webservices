package com.javaguides.springbootrestfullwebservices.mapper;

import com.javaguides.springbootrestfullwebservices.dto.UserDTO;
import com.javaguides.springbootrestfullwebservices.entity.User;

public class UserMapper {

    //convert User JPA Entity to UserDTO Object
    public static UserDTO convertToUserDTO (User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    };
    //convert userDTO object to JPA User Entity
    public static User convertToUserEntity (UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    };
}
