# CODEX CASE STUDY

This project is a Spring Boot application developed using [Spring Boot](https://spring.io/projects/spring-boot).

## About the Project

This application is a RESTful API server built with [Spring Boot](https://spring.io/projects/spring-boot). It provides map information to find nearby places based on a specific coordinate point.

## Requirements

To run this project, you need the following:
- Java 17 or higher
- Maven 3.6 or higher
- A Java IDE (IntelliJ IDEA, Eclipse, etc.)

## Installation

1. Clone the project to your machine:

```bash
git clone https://github.com/username/project-name.git
```

2.Open the application.properties file located in the src/main/resources directory:

Replace the YOUR_GOOGLE_API_KEY placeholder with your actual Google API key

```bash
google.api.key=AIzaSyAphZIQpmekU3Z8jrX0N0GNACFvA07WAXA
```

3.Navigate to the project directory:

```bash
./mvnw spring-boot:run
```

## Usage
After starting the application, you can make requests using the RESTful API as follows:

To find nearby places with a GET request:
```bash
 GET http://localhost:8070/api/findNearbyPlaces?longitude=xx&latitude=yy&radius=zz
```
Here, you can change the longitude, latitude, and radius values based on a specific coordinate point.
