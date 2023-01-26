package com.javaguides.springbootrestfullwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    private Long id;

    //user firstName should not be null / empty
    @NotEmpty(message = "user lastName should not be null / empty")
    private String firstName;

    //user lastName should not be null / empty
    @NotEmpty(message = "user lastName should not be null / empty")
    private String lastName;

    //user email should not be null / empty
    //user email should be a valid email
    @NotEmpty(message = "user email should not be null / empty")
    @Email(message = "user email should be a valid email")
    private String email;

    public UserDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
