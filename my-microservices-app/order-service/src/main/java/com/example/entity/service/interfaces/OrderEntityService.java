package com.example.entity.service.interfaces;

import com.example.entity.Order;
import java.util.List;
import java.util.Optional;


public interface OrderEntityService {

   Order addOrder(Order order);

   Optional<Order> findOrderById(Long id);

   Optional<Order> findByOrderIdAndUserId(Long id, Long userId);

   void deleteOrder(Long id);

   boolean existOrder(Long id);

   List<Order> findAllOrders();
}


