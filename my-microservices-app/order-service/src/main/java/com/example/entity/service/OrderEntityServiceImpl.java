package com.example.entity.service;

import com.example.business.exceptions.OrderNotFoundException;
import com.example.entity.Order;
import com.example.entity.repository.OrderRepository;
import com.example.entity.service.interfaces.OrderEntityService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderEntityServiceImpl implements OrderEntityService {

    private final OrderRepository repository;

    public OrderEntityServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    public Order addOrder(Order order) {
        return repository.save(order);
    }

    public Optional<Order> findOrderById(Long id) {
         return repository.findById(id);
    }

    @Override
    public Optional<Order> findByOrderIdAndUserId(Long id, Long userId) {
       return repository.findByIdAndUserId(id, userId);
    }

    public void deleteOrder(Long id) throws OrderNotFoundException {
        repository.deleteById(id);
    }

    @Override
    public boolean existOrder(Long id) {
       return repository.existsById(id);
    }

    public List<Order> findAllOrders() {
        return repository.findAll();
    }

}