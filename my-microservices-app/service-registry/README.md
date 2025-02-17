# Service Registry Microservice

## Overview
This microservice acts as a service registry using Spring Cloud Netflix Eureka. It allows other microservices to register themselves and discover each other.

## Project Structure
```
service-registry
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── serviceregistry
│   │   │               └── ServiceRegistryApplication.java
│   │   └── resources
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── serviceregistry
│                       └── ServiceRegistryApplicationTests.java
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Prerequisites
- Java 17
- Maven

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   cd service-registry
   ```

2. Build the project using Maven:
   ```
   ./mvnw clean install
   ```

3. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

## Configuration
The application configuration can be found in `src/main/resources/application.yml`. You can customize the server port and Eureka server settings here.

## Usage
Once the service registry is running, other microservices can register themselves with it and use it for service discovery.

## Testing
To run the tests, use the following command:
```
./mvnw test
```

## License
This project is licensed under the MIT License. See the LICENSE file for more details.