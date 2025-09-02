package com.danilotomassoni.crud.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilotomassoni.crud.exceptions.UserNotFoundException;
import com.danilotomassoni.crud.infra.entities.User;
import com.danilotomassoni.crud.infra.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User entity) {
        return repository.saveAndFlush(entity);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Transactional
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public User update(Integer id, User user) {
        User userEntity = repository.findById(id).orElseThrow(() -> new UserNotFoundException(user.getEmail()));

        User userUpdate = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdate);
        return userUpdate;
    }
}
