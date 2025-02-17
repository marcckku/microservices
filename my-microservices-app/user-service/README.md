# FILE: /my-microservices-app/my-microservices-app/user-service/README.md

# User Service

## Overview
The User Service is a microservice responsible for managing user-related operations in the application. It provides RESTful APIs for user registration, retrieval, and deletion.

## Project Structure (allows Swagger UI to calculate endpoints)
```
user-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── business/
│   │   │           │   ├── rules/
│   │   │           │   │   ├── EmailAlreadyExistsException.java
│   │   │           │   │   └── UserNotFoundException.java
│   │   │           │   └── service/
│   │   │           │       ├── interfaces/
│   │   │           │       │   ├── UserBusinessService.java
│   │   │           │       │   └── UserServiceClient.java
│   │   │           │       └── UserBusinessServiceImpl.java
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           │   ├── dtos/
│   │   │           │   │   └── UserDto.java
│   │   │           │   └── UserController.java
│   │   │           ├── entity/
│   │   │           │   ├── mapper/
│   │   │           │   │   └── UserEntityMapper.java
│   │   │           │   ├── repository/
│   │   │           │   │   └── UserRepository.java
│   │   │           │   ├── service/
│   │   │           │   │   ├── interfaces/
│   │   │           │   │   │   └── UserEntityService.java
│   │   │           │   │   └── UserEntityServiceImpl.java
│   │   │           │   └── User.java
│   │   │           ├── utils/
│   │   │           └── UserServiceApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── banner.md
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   ├── business/
│                   │   ├── service/
│                   │   │   └── UserBusinessServiceImplTest.java
│                   │   └── UserEntityServiceImplApplicationTests.java
│                   ├── controller/
│                   │   └── UserControllerTest.java
│                   └── entity/
│                       └── service/
│                           └── UserEntityServiceImplTest.java
│
├── README.md
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
   cd user-service
   ```

2. Build the project using Maven:
   ```
   ./mvnw clean install
   ```

3. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

## Usage
Once the application is running, you can access the following endpoints:
- `POST /users` - Create a new user
- `GET /users/{id}` - Retrieve a user by ID
- `DELETE /users/{id}` - Delete a user by ID

## Testing
To run the tests, use the following command:
```
./mvnw test
```

## License
This project is licensed under the MIT License. See the LICENSE file for more details.



