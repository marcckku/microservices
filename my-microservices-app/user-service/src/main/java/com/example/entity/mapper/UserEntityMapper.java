package com.example.entity.mapper;

import com.example.controller.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import com.example.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

    UserDto toUserDTO(User user);

    User toUser(UserDto userDTO);

    List<User> toListUsers(List<UserDto> dtos);

    List<UserDto> toListDTO(List<User> users);
}
