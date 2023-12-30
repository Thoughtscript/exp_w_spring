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

* `GET http://localhost:8080/api/test`

```
done
```

```bash
2023-12-30T14:38:12.736-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.services.ExampleService  : ======== Non-Static Tests ========
2023-12-30T14:38:12.736-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$D           : y
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$B$C         : y
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$D           : y
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$B$C         : y
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.services.ExampleService  : ======== Field Injection Tests ========
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$D           : d
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.services.ExampleService  : ======== Bean Injection Tests ========
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$B$E         : e
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$B$E         : e
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.services.ExampleService  : ======== Static Tests ========
2023-12-30T14:38:12.737-06:00  INFO 17508 --- [nio-8080-exec-1] i.t.bootexample.interfaces.A$B$C         : staticName
```
