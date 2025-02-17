package com.example.business.service.interfaces;

import com.example.controller.dtos.UserDto;

public interface UserBusinessService {

    UserDto registerUser(UserDto dto);

    UserDto findUserById(Long id);

    void deleteUser(Long id);
}
