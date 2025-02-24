package com.example.apigateway.dtos.request;

public record UserRequestDto(String name, String email)
{
    //Controlli parametri dati dal frontend
    public UserRequestDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name User must not be null or Empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be null or Empty");
        }
    }
}
