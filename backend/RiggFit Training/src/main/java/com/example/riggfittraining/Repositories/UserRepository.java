package com.example.riggfittraining.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.riggfittraining.Entities.User.User;

public interface UserRepository extends JpaRepository<User, Long> {

}