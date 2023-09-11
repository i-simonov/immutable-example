# ImmutableExample

This is a Spring Boot application that represents a basic car repository and provides APIs to fetch car details based on the VIN number or the registration number.

## Overview

The application consists of the following main components:

1. `Car`: This is a class that represents a car with attributes like number, VIN, and colour.

2. `CarIdentifier`: This is a class that represents the identifier of a car which includes number and VIN.

3. `CarRepoService`: This is a service class that maintains a repository of cars and provides methods to add cars, clear cars, and find cars based on the `CarIdentifier`.

4. `Controller`: This is a Spring REST controller that provides an endpoint to get a car's details based on the `CarIdentifier`.

5. `ImmutableExampleApplication`: This is the main application class that starts the Spring Boot application.

6. `ControllerIntTest`: This is a Spring MVC test for the `Controller` class.

## Installation

1. Make sure you have Java 8 or higher installed on your machine.

2. Clone the repository:
   ```
   git clone https://github.com/i-simonov/immutable-example.git
   ```
3. Navigate to the project directory and build the project:
   ```
   cd immutable-example
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
   The application will start and listen on port 8080.

## Usage

The application provides one endpoint:

1. `GET /api/v1/cars`: Returns the car details based on the provided VIN number and/or registration number.
   ```curl 
   http://localhost:8080/api/v1/cars?VIN=111&number=a007
   ```
The response will be the details of the car with the specified VIN number and registration number.

## Running the Tests

To run the tests, execute the following command:
```
mvn test
```

