package com.example.entity.service.interfaces;

import com.example.entity.User;

import java.util.Optional;

public interface UserEntityService {

    User registerUser(User user);

    Optional<User> findUserById(Long id);

    void deleteUser(Long id);

    boolean existByEmail(String email);
}
