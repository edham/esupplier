package com.ebim.esupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebim.esupplier.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String> {}