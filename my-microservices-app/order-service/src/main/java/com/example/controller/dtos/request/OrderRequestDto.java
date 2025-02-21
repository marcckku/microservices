package com.example.controller.dtos.request;


public record OrderRequestDto
        (Long id, Long userId, String productDetails) {
    public OrderRequestDto {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id Order must not be null or negative");
        }
        if (userId == null || userId < 0) {
            throw new IllegalArgumentException("userId must not be null or negative");
        }
        if (productDetails == null || productDetails.isBlank()) {
            throw new IllegalArgumentException("Product details must not be null or Empty");
        }
    }


}