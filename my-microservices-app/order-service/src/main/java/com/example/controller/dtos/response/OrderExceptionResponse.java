package com.example.controller.dtos.response;

import lombok.Builder;

@Builder
public  record OrderExceptionResponse (
        String message,
        int status
) {
}
