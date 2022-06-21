package com.example.ticketbooking.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional <User> findById(Integer id);

    List<User> findAllStudents();

    User save(User entity);

}
