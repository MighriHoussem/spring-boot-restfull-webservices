package com.javaguides.springbootrestfullwebservices.repository;

import com.javaguides.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
}
