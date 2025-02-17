### Project Structure

```plaintext
my-microservices-app
├── api-gateway/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── apigateway/
│   │   │   │               └── ApiGatewayApplication.java [421 bytes]
│   │   │   └── resources/
│   │   │       ├── application.yml [1.04 KB]
│   │   │       └── banner.md [2.86 KB]
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── apigateway/
│   │                       └── ApiGatewayApplicationTests.java [226 bytes]
│   ├── README.md [1.86 KB]
│   ├── mvnw [391 bytes]
│   ├── mvnw.cmd [323 bytes]
│   └── pom.xml [1.45 KB]
├── order-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           ├── business/
│   │   │   │           │   ├── rules/
│   │   │   │           │   │   └── OrderNotFoundException.java [345 bytes]
│   │   │   │           │   └── service/
│   │   │   │           │       ├── interfaces/
│   │   │   │           │       │   ├── OrderBusinessService.java [429 bytes]
│   │   │   │           │       │   └── OrderServiceClient.java [920 bytes]
│   │   │   │           │       └── OrderBusinessServiceImpl.java [1.95 KB]
│   │   │   │           ├── config/
│   │   │   │           ├── controller/
│   │   │   │           │   ├── dtos/
│   │   │   │           │   │   └── OrderDto.java [612 bytes]
│   │   │   │           │   └── OrderController.java [2.01 KB]
│   │   │   │           ├── entity/
│   │   │   │           │   ├── mapper/
│   │   │   │           │   │   └── OrderEntityMapper.java [511 bytes]
│   │   │   │           │   ├── repository/
│   │   │   │           │   │   └── OrderRepository.java [551 bytes]
│   │   │   │           │   ├── service/
│   │   │   │           │   │   ├── interfaces/
│   │   │   │           │   │   │   └── OrderEntityService.java [438 bytes]
│   │   │   │           │   │   └── OrderEntityServiceImpl.java [1.20 KB]
│   │   │   │           │   └── Order.java [1.46 KB]
│   │   │   │           ├── utils/
│   │   │   │           └── OrderServiceApplication.java [498 bytes]
│   │   │   └── resources/
│   │   │       ├── application.yml [1.10 KB]
│   │   │       └── banner.md [3.78 KB]
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   ├── business/
│   │                   │   └── service/
│   │                   │       └── OrderBusinessServiceImplTest.java [2.58 KB]
│   │                   ├── controller/
│   │                   │   └── OrderControllerTest.java [3.66 KB]
│   │                   └── entity/
│   │                       └── service/
│   │                           └── OrderEntityServiceImplTest.java [3.07 KB]
│   │   
│   ├── README.md [2.05 KB]
│   ├── mvnw [393 bytes]
│   ├── mvnw.cmd [318 bytes]
│   └── pom.xml [3.27 KB]
├── order-service-web/
│   └── order-management.html [2.46 KB]
├── service-registry/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── serviceregistry/
│   │   │   │               └── ServiceRegistryApplication.java [4.65 KB]
│   │   │   └── resources/
│   │   │       ├── application.yml [828 bytes]
│   │   │       └── banner.md [3.50 KB]
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── serviceregistry/
│   │                       └── ServiceRegistryApplicationTests.java [236 bytes]
│   ├── README.md [1.61 KB]
│   ├── mvnw [580 bytes]
│   ├── mvnw.cmd [336 bytes]
│   └── pom.xml [2.44 KB]
├── user-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           ├── business/
│   │   │   │           │   ├── rules/
│   │   │   │           │   │   ├── EmailAlreadyExistsException.java [356 bytes]
│   │   │   │           │   │   └── UserNotFoundException.java [341 bytes]
│   │   │   │           │   └── service/
│   │   │   │           │       ├── interfaces/
│   │   │   │           │       │   ├── UserBusinessService.java [255 bytes]
│   │   │   │           │       │   └── UserServiceClient.java [852 bytes]
│   │   │   │           │       └── UserBusinessServiceImpl.java [1.41 KB]
│   │   │   │           ├── config/
│   │   │   │           ├── controller/
│   │   │   │           │   ├── dtos/
│   │   │   │           │   │   └── UserDto.java [460 bytes]
│   │   │   │           │   └── UserController.java [1.41 KB]
│   │   │   │           ├── entity/
│   │   │   │           │   ├── mapper/
│   │   │   │           │   │   └── UserEntityMapper.java [495 bytes]
│   │   │   │           │   ├── repository/
│   │   │   │           │   │   └── UserRepository.java [355 bytes]
│   │   │   │           │   ├── service/
│   │   │   │           │   │   ├── interfaces/
│   │   │   │           │   │   │   └── UserEntityService.java [314 bytes]
│   │   │   │           │   │   └── UserEntityServiceImpl.java [878 bytes]
│   │   │   │           │   └── User.java [1.26 KB]
│   │   │   │           ├── utils/
│   │   │   │           └── UserServiceApplication.java [557 bytes]
│   │   │   └── resources/
│   │   │       ├── application.yml [991 bytes]
│   │   │       └── banner.md [3.46 KB]
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   ├── business/
│   │                   │   ├── service/
│   │                   │   │   └── UserBusinessServiceImplTest.java [3.10 KB]
│   │                   │   └── UserEntityServiceImplApplicationTests.java [239 bytes]
│   │                   ├── controller/
│   │                   │   └── UserControllerTest.java [2.36 KB]
│   │                   └── entity/
│   │                       └── service/
│   │                           └── UserEntityServiceImplTest.java [1.94 KB]
│   ├── README.md [3.42 KB]
│   ├── mvnw [391 bytes]
│   ├── mvnw.cmd [258 bytes]
│   └── pom.xml [3.27 KB]
├── user-service-web/
│   └── user-management.html [1.91 KB]
├── README.md [3.38 KB]
├── mvnw [207 bytes]
├── mvnw.cmd [229 bytes]
└── pom.xml [3.80 KB]
```


### Summary

