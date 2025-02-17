package com.example.entity.mapper;

import com.example.controller.dtos.OrderDto;
import com.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderEntityMapper {

    OrderDto toDTO(Order order);

    Order toOrder(OrderDto orderDTO);

    List<Order> toListOrders(List<OrderDto> dtos);

    List<OrderDto> toListDTO(List<Order> orders);

}
