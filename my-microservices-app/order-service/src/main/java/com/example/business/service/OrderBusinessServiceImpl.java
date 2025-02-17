package com.example.business.service;

import com.example.business.rules.OrderNotFoundException;
import com.example.business.service.interfaces.OrderBusinessService;
import com.example.controller.dtos.OrderDto;
import com.example.entity.Order;
import com.example.entity.service.interfaces.OrderEntityService;
import com.example.entity.mapper.OrderEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {

    private final OrderEntityService entityService;
    private final OrderEntityMapper mapper;

    public OrderBusinessServiceImpl(OrderEntityService entityService, OrderEntityMapper mapper) {
        this.entityService = entityService;
        this.mapper = mapper;
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) throws RuntimeException {
        Order order = entityService.addOrder(mapper.toOrder(orderDto));
        return mapper.toDTO(order);
    }

    @Override
    public OrderDto findOrderById(Long id) {
        Order order = entityService.findOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException("Business Rule : Order not found with id " + id));
        return mapper.toDTO(order);
    }

    @Override
    public OrderDto findOrderByOrderIdAndUserId(Long id, Long userId) {
        Order order = entityService.findByOrderIdAndUserId(id, userId).orElseThrow(() -> new RuntimeException());
        return mapper.toDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
      entityService.deleteOrder(id);
    }

    @Override
    public boolean existsOrder(Long id) {
       return entityService.existOrder(id);
    }

    @Override
    public List<OrderDto> findAllOrders() {
        /** return entityService.findAllOrders().stream().map(entityMapper::toOrderDTO).toList(); */
        return mapper.toListDTO(entityService.findAllOrders());
    }
}
