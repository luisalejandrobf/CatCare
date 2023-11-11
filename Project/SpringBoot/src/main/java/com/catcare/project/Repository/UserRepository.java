package com.catcare.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catcare.project.Entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}