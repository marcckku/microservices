package com.example.handler;


import com.example.business.exceptions.OrderNotFoundException;
import com.example.controller.dtos.ResponseHandler;
import com.example.controller.dtos.response.OrderExceptionResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<OrderExceptionResponse> orderNotFoundException(OrderNotFoundException ex) {
        return ResponseHandler.generateErrorResponse(ex);
    }
}
