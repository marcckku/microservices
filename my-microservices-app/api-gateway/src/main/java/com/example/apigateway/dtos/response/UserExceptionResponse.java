package com.example.apigateway.dtos.response;

import lombok.Builder;


@Builder
public record UserExceptionResponse(
        String message,
        int status
) {}
