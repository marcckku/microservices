//package com.example.apigateway.controller.dtos;
//
//import com.example.business.exceptions.UserBaseException;
//import com.example.controller.dtos.response.UserExceptionResponse;
//import jakarta.validation.constraints.NotNull;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//
//public class ResponseHandler {
//
//    public static ResponseEntity<UserExceptionResponse> generateErrorResponse(@NotNull UserBaseException ex) {
//        return new ResponseEntity<>(UserExceptionResponse
//                .builder()
//                .message(ex.getMessage())
//                .status(ex.getStatus()).build(), HttpStatusCode.valueOf(ex.getStatus()));
//    }
//}
