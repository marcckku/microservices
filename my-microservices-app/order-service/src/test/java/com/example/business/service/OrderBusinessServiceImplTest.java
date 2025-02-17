package com.example.business.service;

import com.example.controller.dtos.OrderDto;
import com.example.entity.Order;
import com.example.entity.service.interfaces.OrderEntityService;
import com.example.entity.mapper.OrderEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class OrderBusinessServiceImplTest {

    @Mock
    private OrderEntityService entityService;

    @Mock
    private OrderEntityMapper entityMapper;

    @InjectMocks
    private OrderBusinessServiceImpl orderBusinessService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void addOrder() {
        OrderDto orderDto = new OrderDto(1L, 1L,  "Product Details");
        Order order = new Order();
        when(entityMapper.toOrder(orderDto)).thenReturn(order);
        when(entityService.addOrder(order)).thenReturn(order);
        when(entityMapper.toDTO(order)).thenReturn(orderDto);

        OrderDto result = orderBusinessService.addOrder(orderDto);

        assertNotNull(result);
        verify(entityService, times(1)).addOrder(order);
    }

    @Test
    void findOrderById() {
        Long id = 1L;
        Order order = new Order();
        OrderDto orderDto = new OrderDto(1L, 1L,  "Product Details");
        when(entityService.findOrderById(id)).thenReturn(Optional.of(order));
        when(entityMapper.toDTO(order)).thenReturn(orderDto);

        OrderDto result = orderBusinessService.findOrderById(id);

        assertNotNull(result);
        verify(entityService, times(1)).findOrderById(id);
    }

    @Test
    void deleteOrder() {
        Long id = 1L;
        doNothing().when(entityService).deleteOrder(id);

        orderBusinessService.deleteOrder(id);

        verify(entityService, times(1)).deleteOrder(id);
    }

    @Test
    void findAllOrders() {
        List<Order> orders = List.of(new Order());
        List<OrderDto> orderDtos = List.of(new OrderDto(1L, 1L,  "Product Details"));
        when(entityService.findAllOrders()).thenReturn(orders);
        when(entityMapper.toListDTO(orders)).thenReturn(orderDtos);

        List<OrderDto> result = orderBusinessService.findAllOrders();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(entityService, times(1)).findAllOrders();
    }
}