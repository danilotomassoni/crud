package com.danilotomassoni.crud.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilotomassoni.crud.infra.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);
}
