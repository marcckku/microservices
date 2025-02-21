package com.example.business.service;

import com.example.business.exceptions.EmailAlreadyExistsException;
import com.example.business.exceptions.UserNotFoundException;
import com.example.controller.dtos.request.UserRequestDto;
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
    private UserRequestDto userRequestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "John Doe", "john.doe@example.com");
        userRequestDto = new UserRequestDto("John Doe", "john.doe@example.com");
    }

    @Test
    void registerUserSuccess() {
        when(entityService.existByEmail(userRequestDto.email())).thenReturn(false);
        when(mapper.toUser(any(UserRequestDto.class))).thenReturn(user);
        when(entityService.registerUser(any(User.class))).thenReturn(user);
        when(mapper.toUserDTO(any(User.class))).thenReturn(userRequestDto);

        UserRequestDto createdUserRequestDto = service.registerUser(userRequestDto);

        assertEquals(userRequestDto.email(), createdUserRequestDto.email());
        verify(entityService, times(1)).existByEmail(userRequestDto.email());
        verify(entityService, times(1)).registerUser(user);
    }

    @Test
    void registerUserEmailAlreadyExistsException() {
        when(entityService.existByEmail(userRequestDto.email())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> service.registerUser(userRequestDto));
        verify(entityService, times(1)).existByEmail(userRequestDto.email());
        verify(entityService, never()).registerUser(any(User.class));
    }

    @Test
    void findUserByIdSuccess() {
        when(entityService.findUserById(1L)).thenReturn(Optional.of(user));
        when(mapper.toUserDTO(any(User.class))).thenReturn(userRequestDto);

        UserRequestDto foundUserRequestDto = service.findUserById(1L);

        assertEquals(userRequestDto.email(), foundUserRequestDto.email());
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