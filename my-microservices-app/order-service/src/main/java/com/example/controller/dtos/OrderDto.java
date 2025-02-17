package com.example.controller.dtos;


public record OrderDto
        (Long id, Long userId, String productDetails) {
    public OrderDto {
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