package com.ebim.esupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebim.esupplier.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRole.UserRoleId> {}