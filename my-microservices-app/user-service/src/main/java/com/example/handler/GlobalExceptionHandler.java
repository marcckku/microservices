package com.example.handler;

import com.example.business.exceptions.EmailAlreadyExistsException;
import com.example.business.exceptions.UserNotFoundException;
import com.example.controller.dtos.ResponseHandler;
import com.example.controller.dtos.response.UserExceptionResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserExceptionResponse> userNotFoundEx(UserNotFoundException ex) {
        return ResponseHandler.generateErrorResponse(ex);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<UserExceptionResponse> emailAlreadyExistsEx(EmailAlreadyExistsException ex) {//, WebRequest request
        return new ResponseHandler().generateErrorResponse(ex);
    }

}
