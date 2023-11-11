package com.catcare.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catcare.project.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}