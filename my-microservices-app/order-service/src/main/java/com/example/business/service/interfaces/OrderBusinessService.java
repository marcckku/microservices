package com.example.business.service.interfaces;

import com.example.controller.dtos.OrderDto;
import java.util.List;


public interface OrderBusinessService {

    OrderDto addOrder(OrderDto order);

    OrderDto findOrderById(Long id);

    OrderDto findOrderByOrderIdAndUserId(Long id, Long userId);

    void deleteOrder(Long id);

    boolean existsOrder(Long id);

    List<OrderDto> findAllOrders();
}
