# exp_w_spring

[![](https://img.shields.io/badge/Java-18-blue.svg)](https://jdk.java.net/archive/)
[![](https://img.shields.io/badge/Spring%20Boot-3.1.4-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Gradle-7.5.1-darkslategray.svg)](https://gradle.org/)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)

Experiments with Java Spring.

## Use

Maven:

```bash
mvn clean
mvn install
mvn spring-boot:run
```

Gradle:

```bash
./gradlew clean
./gradlew build
./gradlew run
```

## API Endpoints

* `GET http://localhost:8080/api/example/getOne`
  * `{"name":"example","exampleList":[{"name":"exampleListItemA"},{"name":"exampleListItemB"},{"name":"exampleListItemC"}]}`

## Resources and Shoutouts

* https://www.baeldung.com/java-system-gc
* https://stackoverflow.com/questions/2015463/how-to-view-the-current-heap-size-that-an-application-is-using