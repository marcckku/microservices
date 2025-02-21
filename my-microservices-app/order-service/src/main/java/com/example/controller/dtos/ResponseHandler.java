package com.example.controller.dtos;

import com.example.business.exceptions.OrderBaseException;
import com.example.controller.dtos.response.OrderExceptionResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<OrderExceptionResponse> generateErrorResponse(OrderBaseException ex) {
        return new ResponseEntity<>(OrderExceptionResponse
                .builder()
                .message(ex.getMessage())
                .status(ex.getStatus()).build(), HttpStatusCode.valueOf(ex.getStatus()));
    }
}
