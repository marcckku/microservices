package com.example.business.service.interfaces;

import com.example.controller.dtos.request.UserRequestDto;

public interface UserBusinessService {

    UserRequestDto registerUser(UserRequestDto dto);

    UserRequestDto findUserById(Long id);

    void deleteUser(Long id);
}
