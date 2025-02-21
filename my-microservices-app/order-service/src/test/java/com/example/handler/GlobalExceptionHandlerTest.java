package com.example.handler;

import com.example.business.exceptions.OrderNotFoundException;
import com.example.controller.dtos.response.OrderExceptionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;
    private String orderNotFoundMessage = String.format("Error - Order not found by id \'%s\'", 66);


    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }


    @Test
    void orderNotFoundException() {
        OrderNotFoundException notFoundException = new OrderNotFoundException(orderNotFoundMessage, HttpStatus.NOT_FOUND.value());
        ResponseEntity<OrderExceptionResponse> response = globalExceptionHandler.orderNotFoundException(notFoundException);
        assertThat(response.getBody().status()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getBody().message()).isEqualTo(orderNotFoundMessage);
    }
}