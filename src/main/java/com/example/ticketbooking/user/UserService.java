package com.example.ticketbooking.user;

import com.example.ticketbooking.exceptions.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(JpaUserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findAllStudents() {
        return repository.findAllStudents();
    }

    User findById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResourceException(HttpStatus.NOT_FOUND, "Did not find user id = " + id));
    }

//    public User addUser(User toSave) {
//        return repository.save(toSave);
//    }
}
