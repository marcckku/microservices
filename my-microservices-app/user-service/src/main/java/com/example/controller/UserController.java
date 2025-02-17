package com.example.controller;

import com.example.business.service.interfaces.UserBusinessService;
import com.example.controller.dtos.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Tag(name = "User Controller", description = "API for user operations")
public class UserController {

    @Autowired
    private UserBusinessService service;

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user")
    @Tag(name = "Post", description = "POST methods of User APIs")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        return new ResponseEntity<>(service.registerUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by ID")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}