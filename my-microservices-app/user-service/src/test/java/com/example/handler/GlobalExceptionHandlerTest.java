package com.example.handler;

import com.example.business.exceptions.EmailAlreadyExistsException;
import com.example.business.exceptions.UserNotFoundException;
import com.example.controller.dtos.response.UserExceptionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;
    private String userNotFoundMessage = String.format("Error User not found with id %s ", 5);
    private String emailAlreadyExistsMessage = String.format("Error Registry User - Email \'%s\' already exists.", "admin@gmail.com");


    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void userNotFoundEx() {
        UserNotFoundException notFoundException = new UserNotFoundException(userNotFoundMessage, HttpStatus.NOT_FOUND.value());
        ResponseEntity<UserExceptionResponse> response = globalExceptionHandler.userNotFoundEx(notFoundException);
        assertThat(response.getBody().status()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getBody().message()).isEqualTo(userNotFoundMessage);
    }

    @Test
    void emailAlreadyExistsEx() {
        EmailAlreadyExistsException emailAlreadyExistsException = new EmailAlreadyExistsException(emailAlreadyExistsMessage, HttpStatus.BAD_REQUEST.value());
        ResponseEntity<UserExceptionResponse> response = globalExceptionHandler.emailAlreadyExistsEx(emailAlreadyExistsException);
        assertThat(response.getBody().status()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getBody().message()).isEqualTo(emailAlreadyExistsException.getMessage());
    }

}