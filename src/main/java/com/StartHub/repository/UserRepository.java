package com.StartHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StartHub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}