package com.example.entity.service;

import com.example.entity.User;
import com.example.entity.repository.UserRepository;
import com.example.entity.service.interfaces.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserRepository repository;

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existByEmail(String email) {
       return repository.existsByEmail(email);
    }
}