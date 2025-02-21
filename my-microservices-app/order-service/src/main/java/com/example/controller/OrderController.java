package com.example.controller;

import com.example.business.service.interfaces.OrderBusinessService;
import com.example.controller.dtos.request.OrderRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order Controller", description = "API for order operations")
public class OrderController {

   private OrderBusinessService service;

    public OrderController(OrderBusinessService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new order")
    public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addOrder(orderRequestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID")
    public ResponseEntity<OrderRequestDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOrderById(id));
    }

    @GetMapping("/{id}/{userId}")
    @Operation(summary = "Get order by Order ID and User id")
    public ResponseEntity<OrderRequestDto> getOrder(@PathVariable Long id, @PathVariable Long userId) {
        return ResponseEntity.ok(service.findOrderByOrderIdAndUserId(id, userId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order by ID")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    @Operation(summary = "Exists Order")
    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
        return ResponseEntity.ok(service.existsOrder(id));
    }


    @GetMapping
    @Operation(summary = "Get all orders")
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        return ResponseEntity.ok(service.findAllOrders());
    }
}