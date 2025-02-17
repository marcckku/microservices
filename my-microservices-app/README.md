# My Microservices App

## Overview
This project is a microservices application built with Java 17 and Spring Boot. 
It serves as a template for developing microservices using the latest technologies and best practices.

## Project Structure
```
my-microservices-app
├── service-registry
├── api-gateway
├── user-service
├── order-service
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Prerequisites
- Java 17
- Maven

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   cd my-microservices-app
   ```

2. Build all modules/projects using Maven from this parent project:
   ```
   ./mvnw clean install
   ```
   or
   ```mvn clean install```
 

3. Start the Microservice in this order: ```service-registry, api-gateway, user-service, and order-service```:

   - For Service Registry:
     ```
     cd service-registry
     ./mvnw spring-boot:run
     ```
   - For API Gateway:
     ```
     cd api-gateway
     ./mvnw spring-boot:run
     ```
   - For User Service:
     ```
     cd user-service
     ./mvnw spring-boot:run
     ```
   - For Order Service:
     ```
     cd order-service
     ./mvnw spring-boot:run
     ```
4. ## Interaction between Microservices
   To enable interaction between microservices ```user-service``` and ```order-service``` or others.
   we can use RestTemplate client or Feign Client. In the pom.xml of each service add the dependency for Feign Client:

   ```
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-openfeign</artifactId>
     </dependency>
   ```

   * Creating a Feign client
     In the user-service, create a Feign client interface to call the order-service. Create a mock customer interface in this case for order service. 
     This interface defines methods for calling the services exposed by Service
     For Order Service:
       ```
         @FeignClient(name = "order-service")
         public interface OrderServiceClient {
            @PostMapping("/order/")
            Order createOrder(@RequestBody Order order);
         }
       ```
     _The **@FeignClient annotation** specifies the name of the service to call._
   
     In this example, the OrderServiceClient interface defines a createOrder method that calls the endpoint
     POST ```/order/``` of the Order service. The **@FeignClient** annotation specifies the name of the service to call.

    * Enable Feign Client **@EnableFeignClients**.
   
       ```
        @SpringBootApplication
        @EnableFeignClients
        public class OrderServiceApplication {
            public static void main(String[] args) {
            SpringApplication.run(OrderServiceApplication.class, args);
           }
        }
       ```
   _Do the same steps for the other services_.

   * Otherwise you can use RestTemplate

       ```
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplateBuilder().build();
        }
       ```

**By following these steps you will have a microservice structure in Java with Spring Boot 3.2.x complete and ready to be extended with specific functionality.**

## Usage
Once the application is running, you can access the endpoints defined in each service's controller. For example, you can call the user service's endpoints to manage users and the order service's endpoints to manage orders.

## Testing
To run the tests for each service, navigate to the respective service directory and use the following command:
```
./mvnw test
```

## License
This project is licensed under the MIT License. See the LICENSE file for more details.