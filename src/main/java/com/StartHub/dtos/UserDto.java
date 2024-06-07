package com.StartHub.dtos;

import com.StartHub.model.User;

import jakarta.persistence.Id;

public class UserDto {
    @Id
    private Long id;

    private String username;

    private String password;

    private String email;

    public UserDto() {

    } 

    public UserDto(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        email = user.getEmail();
        
    } 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
