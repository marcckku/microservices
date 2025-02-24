package com.example.business.service;

import com.example.business.exceptions.EmailAlreadyExistsException;
import com.example.business.exceptions.UserNotFoundException;
import com.example.business.service.interfaces.UserBusinessService;
import com.example.controller.dtos.request.UserRequestDto;
import com.example.entity.User;
import com.example.entity.service.interfaces.UserEntityService;
import com.example.entity.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserBusinessServiceImpl implements UserBusinessService {

    private final UserEntityService entityService;

    private final UserEntityMapper mapper;

    @Override
    public UserRequestDto registerUser(UserRequestDto dto){
        if (entityService.existByEmail(dto.email())) {
            String message = String.format("Error Registry User - Email \'%s\' already exists.", dto.email());
            log.info(message);
            throw new EmailAlreadyExistsException(message);
        }
        User user = mapper.toUser(dto);
        log.info("Success Registry User {}", user);
        return mapper.toUserDTO(entityService.registerUser(user));
    }

    @Override
    public UserRequestDto findUserById(Long id) {
        User user = entityService.findUserById(id)
                .orElseThrow(() -> {
                    String message = String.format("Error User not found with id \'%s\'", id);
                    log.info(message);
                    return new UserNotFoundException(message);
                });
        log.info("Success found User by id {}", user);
        return mapper.toUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Success delete User by id {}", id);
        entityService.deleteUser(id);
    }
}
