package com.example.business.service;

import com.example.business.rules.EmailAlreadyExistsException;
import com.example.business.rules.UserNotFoundException;
import com.example.controller.dtos.UserDto;
import com.example.entity.User;
import com.example.entity.service.interfaces.UserEntityService;
import com.example.entity.mapper.UserEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserBusinessServiceImplTest {

    @Mock
    private UserEntityService entityService;

    @Mock
    private UserEntityMapper mapper;

    @InjectMocks
    private UserBusinessServiceImpl service;

    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "John Doe", "john.doe@example.com");
        userDto = new UserDto("John Doe", "john.doe@example.com");
    }

    @Test
    void registerUserSuccess() {
        when(entityService.existByEmail(userDto.email())).thenReturn(false);
        when(mapper.toUser(any(UserDto.class))).thenReturn(user);
        when(entityService.registerUser(any(User.class))).thenReturn(user);
        when(mapper.toUserDTO(any(User.class))).thenReturn(userDto);

        UserDto createdUserDto = service.registerUser(userDto);

        assertEquals(userDto.email(), createdUserDto.email());
        verify(entityService, times(1)).existByEmail(userDto.email());
        verify(entityService, times(1)).registerUser(user);
    }

    @Test
    void registerUserEmailAlreadyExists() {
        when(entityService.existByEmail(userDto.email())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> service.registerUser(userDto));
        verify(entityService, times(1)).existByEmail(userDto.email());
        verify(entityService, never()).registerUser(any(User.class));
    }

    @Test
    void findUserByIdSuccess() {
        when(entityService.findUserById(1L)).thenReturn(Optional.of(user));
        when(mapper.toUserDTO(any(User.class))).thenReturn(userDto);

        UserDto foundUserDto = service.findUserById(1L);

        assertEquals(userDto.email(), foundUserDto.email());
        verify(entityService, times(1)).findUserById(1L);
    }

    @Test
    void findUserByIdUserNotFound() {
        when(entityService.findUserById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> service.findUserById(1L));
        verify(entityService, times(1)).findUserById(1L);
    }

    @Test
    void deleteUser() {
        doNothing().when(entityService).deleteUser(1L);

        service.deleteUser(1L);

        verify(entityService, times(1)).deleteUser(1L);
    }
}