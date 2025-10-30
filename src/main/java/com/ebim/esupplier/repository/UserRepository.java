package com.ebim.esupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebim.esupplier.domain.User;

import java.util.Optional;

// ID actualizado a String
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}