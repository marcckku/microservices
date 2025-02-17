package com.example.controller;

import com.example.business.service.interfaces.OrderBusinessService;
import com.example.controller.dtos.OrderDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    @Mock
    private OrderBusinessService service;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    private OrderDto orderDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        orderDto = new OrderDto(1L, 2L, "Sample Order");
    }

    @Test
    void createOrder() throws Exception {
        when(service.addOrder(any(OrderDto.class))).thenReturn(orderDto);
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1, \"userId\":1, \"productDetails\":\"Sample Order\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(orderDto.id()))
                .andExpect(jsonPath("$.userId").value(orderDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderDto.productDetails()));
    }

    @Test
    void getOrder() throws Exception {
        when(service.findOrderById(1L)).thenReturn(orderDto);
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderDto.id()))
                .andExpect(jsonPath("$.userId").value(orderDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderDto.productDetails()));
    }

    @Test
    void getOrderByOrderIdAndUserId() throws Exception {
        when(service.findOrderByOrderIdAndUserId(1L, 1L)).thenReturn(orderDto);
        mockMvc.perform(get("/api/orders/1/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderDto.id()))
                .andExpect(jsonPath("$.userId").value(orderDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderDto.productDetails()));
    }

    @Test
    void deleteOrder() throws Exception {
        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void existsOrder() throws Exception {
        when(service.existsOrder(1L)).thenReturn(true);
        mockMvc.perform(get("/api/orders/exists/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void getAllOrders() throws Exception {
        List<OrderDto> orders = List.of(orderDto);
        when(service.findAllOrders()).thenReturn(orders);
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(orderDto.id()))
                .andExpect(jsonPath("$[0].userId").value(orderDto.userId()))
                .andExpect(jsonPath("$[0].productDetails").value(orderDto.productDetails()));
    }
}