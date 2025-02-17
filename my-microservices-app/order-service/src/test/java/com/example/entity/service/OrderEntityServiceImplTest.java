package com.example.entity.service;

import com.example.entity.Order;
import com.example.entity.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class OrderEntityServiceImplTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderEntityServiceImpl orderEntityService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void addOrder() {
        Order order = new Order();
        when(repository.save(order)).thenReturn(order);

        Order result = orderEntityService.addOrder(order);

        assertTrue(result != null);
        verify(repository, times(1)).save(order);
    }

    @Test
    void findOrderById() {
        Long id = 1L;
        Order order = new Order();
        when(repository.findById(id)).thenReturn(Optional.of(order));

        Optional<Order> result = orderEntityService.findOrderById(id);

        assertTrue(result.isPresent());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void findByOrderIdAndUserId(){
        Long id = 1L;
        Long userId = 2L;
        Order order = new Order(id, userId, "Some details product");
        when(repository.findByIdAndUserId(id, userId)).thenReturn(Optional.of(order));
        Optional<Order> result = orderEntityService.findByOrderIdAndUserId(id, userId);
        assertTrue(result.isPresent());
       // verify(repository, times(1)).findById(id);
    }

    @Test
    void deleteOrderFound(){
        Long id = 1L;
        Order order = new Order();
        when(repository.findById(id)).thenReturn(Optional.of(order));
        doNothing().when(repository).delete(order);
        orderEntityService.deleteOrder(id);
//        verify(repository, times(1)).delete(order);
    }

    @Test
    void deleteOrderNotFound(){
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        orderEntityService.deleteOrder(id);
    }

    @Test
    void existOrderTrue(){
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(true);
        assertTrue(orderEntityService.existOrder(id));
        verify(repository, times(1)).existsById(id);
    }

    @Test
    void existOrderFalse(){
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(false);
        assertFalse(orderEntityService.existOrder(id));
        verify(repository, times(1)).existsById(id);
    }

    @Test
    void findAllOrders() {
        List<Order> orders = List.of(new Order());
        when(repository.findAll()).thenReturn(orders);

        List<Order> result = orderEntityService.findAllOrders();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }
}