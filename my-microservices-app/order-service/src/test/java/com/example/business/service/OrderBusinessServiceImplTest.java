package com.example.business.service;

import com.example.business.exceptions.OrderNotFoundException;
import com.example.controller.dtos.request.OrderRequestDto;
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
        OrderRequestDto orderRequestDto = new OrderRequestDto(1L, 1L,  "Product Details");
        Order order = new Order();
        when(entityMapper.toOrder(orderRequestDto)).thenReturn(order);
        when(entityService.addOrder(order)).thenReturn(order);
        when(entityMapper.toDTO(order)).thenReturn(orderRequestDto);

        OrderRequestDto result = orderBusinessService.addOrder(orderRequestDto);

        assertNotNull(result);
        verify(entityService, times(1)).addOrder(order);
    }

    @Test
    void findOrderByOrderIdAndUserId() {
        Long orderId = 1L;
        Long userId = 1L;
        Order order = new Order();
        OrderRequestDto orderRequestDto = new OrderRequestDto(orderId, userId, "Product Details");
        when(entityService.findByOrderIdAndUserId(orderId, userId)).thenReturn(Optional.of(order));
        when(entityMapper.toDTO(order)).thenReturn(orderRequestDto);

        OrderRequestDto result = orderBusinessService.findOrderByOrderIdAndUserId(orderId, userId);

        assertNotNull(result);
        verify(entityService, times(1)).findByOrderIdAndUserId(orderId, userId);
    }

    @Test
    void findOrderByOrderIdAndUserIdNotFoundException() {
        Long orderId = 1L;
        Long userId = 1L;
        when(entityService.findByOrderIdAndUserId(orderId, userId)).thenReturn(Optional.empty());

        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> {
            orderBusinessService.findOrderByOrderIdAndUserId(orderId, userId);
        });

        assertEquals("Error - Order not found by id '1' Order or User '1'", exception.getMessage());
        verify(entityService, times(1)).findByOrderIdAndUserId(orderId, userId);
    }

    @Test
    void findOrderById() {
        Long id = 1L;
        Order order = new Order();
        OrderRequestDto orderRequestDto = new OrderRequestDto(1L, 1L,  "Product Details");
        when(entityService.findOrderById(id)).thenReturn(Optional.of(order));
        when(entityMapper.toDTO(order)).thenReturn(orderRequestDto);

        OrderRequestDto result = orderBusinessService.findOrderById(id);

        assertNotNull(result);
        verify(entityService, times(1)).findOrderById(id);
    }
    @Test
    void findOrderByIdNotFoundException() {
        Long id = 1L;
        when(entityService.findOrderById(id)).thenReturn(Optional.empty());

        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> {
            orderBusinessService.findOrderById(id);
        });

        assertEquals("Error - Order not found by id '1'", exception.getMessage());
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
    void existsOrder() {
        Long id = 1L;
        when(entityService.existOrder(id)).thenReturn(true);
        boolean result = orderBusinessService.existsOrder(id);
        assertTrue(result);
        verify(entityService, times(1)).existOrder(id);
    }

    @Test
    void findAllOrders() {
        List<Order> orders = List.of(new Order());
        List<OrderRequestDto> orderRequestDtos = List.of(new OrderRequestDto(1L, 1L,  "Product Details"));
        when(entityService.findAllOrders()).thenReturn(orders);
        when(entityMapper.toListDTO(orders)).thenReturn(orderRequestDtos);

        List<OrderRequestDto> result = orderBusinessService.findAllOrders();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(entityService, times(1)).findAllOrders();
    }
}