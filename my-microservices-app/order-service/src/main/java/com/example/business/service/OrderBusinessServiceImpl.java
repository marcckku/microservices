package com.example.business.service;

import com.example.business.exceptions.OrderNotFoundException;
import com.example.business.service.interfaces.OrderBusinessService;
import com.example.controller.dtos.request.OrderRequestDto;
import com.example.entity.Order;
import com.example.entity.service.interfaces.OrderEntityService;
import com.example.entity.mapper.OrderEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderBusinessServiceImpl implements OrderBusinessService {

    private final OrderEntityService entityService;
    private final OrderEntityMapper mapper;

    public OrderBusinessServiceImpl(OrderEntityService entityService, OrderEntityMapper mapper) {
        this.entityService = entityService;
        this.mapper = mapper;
    }

    @Override
    public OrderRequestDto addOrder(OrderRequestDto orderRequestDto) throws RuntimeException {
        Order order = entityService.addOrder(mapper.toOrder(orderRequestDto));
        return mapper.toDTO(order);
    }

    @Override
    public OrderRequestDto findOrderById(Long id) {
        Order order = entityService.findOrderById(id)
                .orElseThrow(() ->{
                    String message = String.format("Error - Order not found by id \'%s\'", id);
                    log.info(message);
                    throw new OrderNotFoundException(message);
                });
        log.info("Success found Order by id {}", id);
        return mapper.toDTO(order);
    }

    @Override
    public OrderRequestDto findOrderByOrderIdAndUserId(Long id, Long userId) {
        Order order = entityService.findByOrderIdAndUserId(id, userId).orElseThrow(() -> {
            String message = String.format("Error - Order not found by id \'%s\' Order or User \'%s\'", id, userId);
            log.info(message);
            throw new OrderNotFoundException(message);
        });
        log.info("Success found Order by id {} and User {}", id, userId);
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
    public List<OrderRequestDto> findAllOrders() {
        /** return entityService.findAllOrders().stream().map(entityMapper::toOrderDTO).toList(); */
        return mapper.toListDTO(entityService.findAllOrders());
    }
}
