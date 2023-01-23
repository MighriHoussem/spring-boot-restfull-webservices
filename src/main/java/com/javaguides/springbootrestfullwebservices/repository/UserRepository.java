package com.javaguides.springbootrestfullwebservices.repository;

import com.javaguides.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
