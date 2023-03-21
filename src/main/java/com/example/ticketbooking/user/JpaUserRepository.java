package com.example.ticketbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends UserRepository, JpaRepository<User, Integer> {

    @Override
    @Query(nativeQuery = true, value = "select * from users where ticket_type = 'Student'")
    List<User> findAllStudents();

}
