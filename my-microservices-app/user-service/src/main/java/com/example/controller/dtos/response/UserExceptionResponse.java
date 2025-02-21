package com.example.controller.dtos.response;

import lombok.Builder;


@Builder
public record UserExceptionResponse(
        String message,
        int status
) {}
