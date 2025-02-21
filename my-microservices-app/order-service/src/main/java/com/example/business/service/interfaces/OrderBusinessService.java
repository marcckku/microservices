package com.example.business.service.interfaces;

import com.example.controller.dtos.request.OrderRequestDto;
import java.util.List;


public interface OrderBusinessService {

    OrderRequestDto addOrder(OrderRequestDto order);

    OrderRequestDto findOrderById(Long id);

    OrderRequestDto findOrderByOrderIdAndUserId(Long id, Long userId);

    void deleteOrder(Long id);

    boolean existsOrder(Long id);

    List<OrderRequestDto> findAllOrders();
}
