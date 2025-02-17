package com.example.business.service;

import com.example.business.rules.EmailAlreadyExistsException;
import com.example.business.rules.UserNotFoundException;
import com.example.business.service.interfaces.UserBusinessService;
import com.example.entity.User;
import com.example.entity.service.interfaces.UserEntityService;
import com.example.controller.dtos.UserDto;
import com.example.entity.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserEntityService entityService;
    @Autowired
    private UserEntityMapper mapper;

    @Override
    public UserDto registerUser(UserDto dto){
      if (entityService.existByEmail(dto.email())) {
          throw new EmailAlreadyExistsException("Business Rule : Email already exists");
      }
      User user = mapper.toUser(dto);
      return mapper.toUserDTO(entityService.registerUser(user));
    }

    @Override
    public UserDto findUserById(Long id) {
      User user = entityService.findUserById(id)
              .orElseThrow(() -> new UserNotFoundException("Business Rule : User not found with id " + id));
      return mapper.toUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityService.deleteUser(id);
    }
}
