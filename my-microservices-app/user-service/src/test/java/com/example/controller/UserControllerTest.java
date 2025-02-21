package com.example.controller;

import com.example.business.service.interfaces.UserBusinessService;
import com.example.controller.dtos.request.UserRequestDto;
import com.example.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Mock
    private UserBusinessService service;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private User user;
    private UserRequestDto userRequestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User(1L, "John Doe", "john.doe@example.com");
        userRequestDto = new UserRequestDto("John Doe", "john.doe@example.com");
    }

    @Test
    void createUser() throws Exception {
        when(service.registerUser(any(UserRequestDto.class))).thenReturn(userRequestDto);
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(userRequestDto.name()))
                .andExpect(jsonPath("$.email").value(userRequestDto.email()));
    }

    @Test
    void getUser() throws Exception {
        when(service.findUserById(1L)).thenReturn(userRequestDto);
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(userRequestDto.name()))
                .andExpect(jsonPath("$.email").value(userRequestDto.email()));
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}