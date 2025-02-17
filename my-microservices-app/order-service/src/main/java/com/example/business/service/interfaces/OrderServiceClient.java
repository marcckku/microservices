package com.example.business.service.interfaces;

import com.example.controller.dtos.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
/**
 * This interface is a Feign client to be able to call this service from another service.
 * The @FeignClient annotation specifies the name of the service to call.
 */

@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @PostMapping("/api/orders")
    OrderDto addOrder(OrderDto order);

    @GetMapping("/api/orders/{id}")
    OrderDto findOrderById(Long id);

    @DeleteMapping("/api/orders/{id}")
    void deleteOrder(Long id);

    @GetMapping("/api/orders")
    List<OrderDto> findAllOrders();
}
