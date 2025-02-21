package com.example.entity.mapper;

import com.example.controller.dtos.request.OrderRequestDto;
import com.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderEntityMapper {

    OrderRequestDto toDTO(Order order);

    Order toOrder(OrderRequestDto orderRequestDTO);

    List<Order> toListOrders(List<OrderRequestDto> dtos);

    List<OrderRequestDto> toListDTO(List<Order> orders);

}
