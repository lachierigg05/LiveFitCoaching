package com.example.riggfittraining.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.riggfittraining.Entities.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}