package com.example.controller;

import com.example.business.service.interfaces.OrderBusinessService;
import com.example.controller.dtos.request.OrderRequestDto;
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

    private OrderRequestDto orderRequestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        orderRequestDto = new OrderRequestDto(1L, 2L, "Sample Order");
    }

    @Test
    void createOrder() throws Exception {
        when(service.addOrder(any(OrderRequestDto.class))).thenReturn(orderRequestDto);
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1, \"userId\":1, \"productDetails\":\"Sample Order\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(orderRequestDto.id()))
                .andExpect(jsonPath("$.userId").value(orderRequestDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderRequestDto.productDetails()));
    }

    @Test
    void getOrder() throws Exception {
        when(service.findOrderById(1L)).thenReturn(orderRequestDto);
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderRequestDto.id()))
                .andExpect(jsonPath("$.userId").value(orderRequestDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderRequestDto.productDetails()));
    }

    @Test
    void getOrderByOrderIdAndUserId() throws Exception {
        when(service.findOrderByOrderIdAndUserId(1L, 1L)).thenReturn(orderRequestDto);
        mockMvc.perform(get("/api/orders/1/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderRequestDto.id()))
                .andExpect(jsonPath("$.userId").value(orderRequestDto.userId()))
                .andExpect(jsonPath("$.productDetails").value(orderRequestDto.productDetails()));
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
        List<OrderRequestDto> orders = List.of(orderRequestDto);
        when(service.findAllOrders()).thenReturn(orders);
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(orderRequestDto.id()))
                .andExpect(jsonPath("$[0].userId").value(orderRequestDto.userId()))
                .andExpect(jsonPath("$[0].productDetails").value(orderRequestDto.productDetails()));
    }
}