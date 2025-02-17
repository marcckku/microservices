package com.example.entity.service;

import com.example.entity.User;
import com.example.entity.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserEntityServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserEntityServiceImpl service;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void registerUser() {
        when(repository.save(any(User.class))).thenReturn(user);
        User createdUser = service.registerUser(user);
        assertEquals(user.getId(), createdUser.getId());
        verify(repository, times(1)).save(user);
    }

    @Test
    void findUserById() {
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        Optional<User> foundUser = service.findUserById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deleteUser() {
        doNothing().when(repository).deleteById(1L);
        service.deleteUser(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void existByEmail() {
        when(repository.existsByEmail("john.doe@example.com")).thenReturn(true);
        boolean exists = service.existByEmail("john.doe@example.com");
        assertTrue(exists);
        verify(repository, times(1)).existsByEmail("john.doe@example.com");
    }
}