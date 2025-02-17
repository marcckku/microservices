package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//@EnableEurekaClient: This annotation is specific to Eureka, a service registry provided by Netflix.
// It enables the service to register itself with a Eureka server.

//@EnableDiscoveryClient: This is a more generic annotation that works with various service discovery
// implementations, including Eureka, Consul, and Zookeeper. It allows the service to register with
// any supported service registry.

//The services are registered using the name indicated in the spring.application.name property
//as the serviceId, or registration key.

@SpringBootApplication
@EnableDiscoveryClient//Enable service registration on the 'service registry'
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}