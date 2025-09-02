package com.danilotomassoni.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danilotomassoni.crud.business.services.UserService;
import com.danilotomassoni.crud.infra.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok().body(service.save(user));
    }

    @GetMapping
    public ResponseEntity<User> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok().body(service.findByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String email) {
        service.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestParam Integer id, @RequestBody User user) {
        return ResponseEntity.ok().body(service.update(id, user));
    }
}
