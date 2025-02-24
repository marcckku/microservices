package com.example.entity.mapper;

import com.example.controller.dtos.request.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import com.example.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

    UserRequestDto toUserDTO(User user);

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequestDto userRequestDTO);

    List<User> toListUsers(List<UserRequestDto> dtos);

    List<UserRequestDto> toListDTO(List<User> users);
}
