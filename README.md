# Spring Boot Microservices Project

## Prerequisites

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)

### IDE Prerequisites
- [Lombok](https://projectlombok.org/)

## Frameworks
- Spring Boot
- Spring Data JPA
- Spring Web
- Swagger
- Liquibase

## Build Jar Artifact
Command to create a jar file on path *./build/lib* to execute.
```sh
gradlew build
```

## Run Application
```sh
gradlew bootRun
```
## <img align="center" height="30" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg"> Run with Docker 
```sh
# Build docker image
docker build -t microservices-app-image .

# Create and run docker container from image
docker run --name microservices-app-container -p 8080:8080 -d microservices-app-image
```