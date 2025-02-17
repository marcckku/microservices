package com.example.controller.dtos;

public record UserDto(String name, String email)
{
    //Controlli parametri dati dal frontend
    public UserDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name User must not be null or Empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be null or Empty");
        }
    }
}
