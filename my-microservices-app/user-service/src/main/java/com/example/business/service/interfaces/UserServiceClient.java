package com.example.business.service.interfaces;

import com.example.controller.dtos.request.UserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * This interface is a fake client, which allows you to call this service from another service.
 * The @FeignClient annotation specifies the name of the service to call in this case "user-service".
 */

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @PostMapping("/api/users")
    UserRequestDto registerUser(UserRequestDto dto);

    @GetMapping("/api/users/{id}")
    UserRequestDto findUserById(Long id);

    @DeleteMapping("/api/users/{id}")
    void deleteUser(Long id);
}
