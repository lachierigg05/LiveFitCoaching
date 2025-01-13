package com.example.riggfittraining.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.riggfittraining.Entities.User.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}
