package com.example.ticketbooking.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    UserController (final UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/users/students")
    List<User> findAllStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/users/{id}")
    User findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/users")
    User addUser(@RequestBody User newUser) {
        return service.addUser(newUser);
    }


}
