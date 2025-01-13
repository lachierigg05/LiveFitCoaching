package com.example.riggfittraining.Repositories;

import com.example.riggfittraining.Entities.User.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
