# README

[![](https://img.shields.io/badge/Java-1.18-yellowgreen.svg)](https://www.oracle.com/java/technologies/downloads/#java18)
[![](https://img.shields.io/badge/Spring%20Boot-2.7.5-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Gradle-7.5.1-darkslategray.svg)](https://gradle.org/)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)

## Install

Maven, Gradle, etc.

## Use

```BASH
mvn clean
mvn install
mvn spring-boot:run
```

Gradle:

```BASH
./gradlew clean
./gradlew build
./gradlew run
```

## API Endpoints

* `GET http://localhost:8080/api/get/one`

```
{"userId":1,"id":1,"title":"delectus aut autem","completed":false}
```

## Resources and Links

- https://reflectoring.io/spring-resttemplate/