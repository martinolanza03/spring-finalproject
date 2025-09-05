package com.finalproject.spring_finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.spring_finalproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
