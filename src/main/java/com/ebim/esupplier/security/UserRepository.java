package com.ebim.esupplier.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// ID actualizado a String
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}